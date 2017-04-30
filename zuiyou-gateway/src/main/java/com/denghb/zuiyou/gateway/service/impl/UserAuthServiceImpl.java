package com.denghb.zuiyou.gateway.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.dbhelper.utils.DbHelperUtils;
import com.denghb.zuiyou.domain.UserAuth;
import com.denghb.zuiyou.gateway.criteria.UserAuthCriteria;
import com.denghb.zuiyou.gateway.exception.ZuiyouException;
import com.denghb.zuiyou.gateway.model.Credential;
import com.denghb.zuiyou.gateway.service.UserAuthService;
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

    private UserAuth queryByUserId(long userId, String pdu) {
        UserAuth ua = db.queryForObject("select * from user_auth where user_id = ? and pdu = ? ", UserAuth.class, userId, pdu);
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
    public void open(Credential credential, String pdu) {
        long userId = credential.getUserId();
        UserAuth ua = queryByUserId(userId, pdu);
        ua.setIsOpen(true);
        db.updateById(ua);
    }

    @Override
    public void close(Credential credential, String pdu) {
        long userId = credential.getUserId();
        UserAuth ua = queryByUserId(userId, pdu);
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

    @Override
    public PagingResult<UserAuth> list(Credential credential, UserAuthCriteria criteria) {
        StringBuffer sql = new StringBuffer();
        sql.append(DbHelperUtils.getSelectSql(UserAuth.class));
        sql.append("where user_id = ? and deleted = 0");
        criteria.getParams().add(credential.getUserId());
        return db.list(sql, UserAuth.class, criteria);
    }
}
