package com.denghb.zuiyou.domain.vo;

import com.denghb.zuiyou.domain.UserAuth;

/**
 * Created by denghb on 2017/4/20.
 */
public class UserAuthVo extends UserAuth {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserAuthVo{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
