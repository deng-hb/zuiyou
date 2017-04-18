package com.denghb.zuiyou.service.impl;

import com.denghb.zuiyou.domain.User;
import com.denghb.zuiyou.service.UserService;
import com.denghb.dbhelper.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by denghb on 2017/4/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DbHelper db;

    @Override
    public User signin(String username, String password) {
        User user = db.queryForObject("select * from user where username = ? and password = ?", User.class, username, password);

        return user;
    }

    @Override
    @Transactional
    public User signup(String email, String password) {

        User user = new User();
        user.setEmail(email);
        user.setUsername(email);
        user.setPassword(password);
        db.insert(user);

        return user;
    }
}
