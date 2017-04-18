package com.denghb.zuiyou.service.impl;

import com.denghb.zuiyou.domain.UserRuleAuth;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.service.UserRuleAuthService;
import com.denghb.dbhelper.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by denghb on 2017/4/11.
 */
@Service
public class UserRuleAuthServiceImpl implements UserRuleAuthService {

    @Autowired
    private DbHelper db;

    @Override
    @Transactional
    public void bind(CurrentUser currentUser, String pdu, String cookie) {
        long userId = currentUser.getUserId();
        // is_open = 1 表示启用
        UserRuleAuth ura = db.queryForObject("select * from user_rule_auth where and user_id = ? and pdu = ? ", UserRuleAuth.class, userId, pdu);
        if (null != ura) {
            // 更新
            ura.setAuth(cookie);
            db.updateById(ura);
        } else {
            // 新建
            ura = new UserRuleAuth();
            ura.setAuth(cookie);
            ura.setPdu(pdu);
            ura.setUserId(userId);
            db.insert(ura);
        }
    }
}
