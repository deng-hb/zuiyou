package com.denghb.zuiyou.service;


import com.denghb.zuiyou.model.CurrentUser;

/**
 * Created by denghb on 2017/4/11.
 */
public interface UserRuleAuthService {


    /**
     * 绑定用户
     *
     * @param currentUser
     * @param pdu
     * @param token
     */
    void bind(CurrentUser currentUser, String pdu, String token);
}
