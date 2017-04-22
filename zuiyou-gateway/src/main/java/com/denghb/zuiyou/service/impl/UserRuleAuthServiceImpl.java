package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.UserRuleAuth;
import com.denghb.zuiyou.domain.vo.UserRuleAuthVo;
import com.denghb.zuiyou.exception.ZuiyouException;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.server.NioServer;
import com.denghb.zuiyou.service.UserRuleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/11.
 */
@Service
public class UserRuleAuthServiceImpl implements UserRuleAuthService {

    @Autowired
    private DbHelper db;

    @Override
    @Transactional
    public void bind(CurrentUser currentUser, String pdu, String token) {
        long userId = currentUser.getUserId();
        // is_open = 1 表示启用
        UserRuleAuth ura = db.queryForObject("select * from user_rule_auth where user_id = ? and pdu = ? limit 1", UserRuleAuth.class, userId, pdu);
        if (null != ura) {
            // 更新
            ura.setToken(token);
            ura.setStatus(1);
            db.updateById(ura);
        } else {
            // 新建
            ura = new UserRuleAuth();
            ura.setToken(token);
            ura.setPdu(pdu);
            ura.setUserId(userId);
            db.insert(ura);
        }
    }

    @Override
    public UserRuleAuthVo queryUserRuleAuthInfo(CurrentUser currentUser) {
        UserRuleAuthVo vo = db.queryForObject("select * from user_rule_auth where user_id = ? limit 1", UserRuleAuthVo.class, currentUser.getUserId());

        if (null != vo) {
            Rule rule = db.queryById(Rule.class, vo.getRuleId());
            vo.setUsername(currentUser.getUsername());
            vo.setRule(rule);
        }
        return vo;
    }


    @Override
    public void open(CurrentUser currentUser) {
        long userId = currentUser.getUserId();
        UserRuleAuth ura = db.queryForObject("select * from user_rule_auth where user_id = ? limit 1 ", UserRuleAuth.class, userId);
        ura.setIsOpen(true);
        db.updateById(ura);

        NioServer.sendCommand(Constants.Command.UPDATE_RULE);
    }

    @Override
    public void close(CurrentUser currentUser) {
        long userId = currentUser.getUserId();
        UserRuleAuth ura = db.queryForObject("select * from user_rule_auth where user_id = ? limit 1 ", UserRuleAuth.class, userId);
        ura.setIsOpen(false);
        db.updateById(ura);

        NioServer.sendCommand(Constants.Command.UPDATE_RULE);
    }

    @Override
    public void updateBalance(String pdu, BigDecimal balance) throws ZuiyouException {
        // pdu 唯一
        int res = db.execute("update user_rule_auth set balance = ? where pdu = ?", balance, pdu);
        if (1 != res) {
            throw new ZuiyouException("余额更新失败");
        }
    }

    @Override
    public void invalid(String pdu) throws ZuiyouException {
        // pdu 唯一
        int res = db.execute("update user_rule_auth set status = 0 where pdu = ?", pdu);
        if (1 != res) {
            throw new ZuiyouException("授权失效更新失败");
        }
    }
}
