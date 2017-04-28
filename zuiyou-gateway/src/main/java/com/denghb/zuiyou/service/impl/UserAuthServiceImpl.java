package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.domain.UserAuth;
import com.denghb.zuiyou.domain.vo.UserAuthVo;
import com.denghb.zuiyou.exception.ZuiyouException;
import com.denghb.zuiyou.model.Credential;
import com.denghb.zuiyou.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/11.
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private DbHelper db;

    private UserAuth queryByUserId(long userId) {
        UserAuth ua = db.queryForObject("select * from user_auth where user_id = ? limit 1 ", UserAuth.class, userId);
        return ua;
    }

    @Override
    @Transactional
    public void bind(Credential credential, String pdu, String token) {
        long userId = credential.getUserId();
        //
        UserAuth ua = db.queryForObject("select * from user_auth where user_id = ? and pdu = ? limit 1", UserAuth.class, userId, pdu);
        if (null != ua) {
            // 更新
            ua.setToken(token);
            ua.setStatus(1);
            db.updateById(ua);
        } else {
            // 新建
            ua = new UserAuth();
            ua.setStatus(1);
            ua.setToken(token);
            ua.setPdu(pdu);
            ua.setUserId(userId);
            db.insert(ua);
        }
    }

    @Override
    public UserAuthVo queryUserAuthInfo(Credential credential) {
        // TODO 暂时一个用户只能绑定一个
        UserAuthVo vo = db.queryForObject("select * from user_auth ua left join user u on ra.user_id = u.user_id where user_id = ? limit 1", UserAuthVo.class, credential.getUserId());

        return vo;
    }


    @Override
    public void open(Credential credential) {
        long userId = credential.getUserId();
        UserAuth ua = queryByUserId(userId);
        ua.setIsOpen(true);
        db.updateById(ua);
    }

    @Override
    public void close(Credential credential) {
        long userId = credential.getUserId();
        UserAuth ua = queryByUserId(userId);
        ua.setIsOpen(false);
        db.updateById(ua);
    }

    @Override
    public void updateBalance(String pdu, BigDecimal balance) throws ZuiyouException {
        // pdu 唯一
        int res = db.execute("update user_auth set balance = ? where pdu = ?", balance, pdu);
        if (1 != res) {
            throw new ZuiyouException("余额更新失败");
        }
    }

    @Override
    public void invalid(String pdu) throws ZuiyouException {
        // pdu 唯一
        int res = db.execute("update user_auth set status = 0 where pdu = ?", pdu);
        if (1 != res) {
            throw new ZuiyouException("授权失效更新失败");
        }
    }
}
