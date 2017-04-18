package com.denghb.zuiyou.service;

import com.denghb.zuiyou.domain.User;

/**
 * Created by denghb on 2017/4/16.
 */
public interface UserService {

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     */
    User signin(String username, String password);

    /**
     * 注册
     *
     * @param email
     * @param password
     * @return
     */
    User signup(String email, String password);
}
