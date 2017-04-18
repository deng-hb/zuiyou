package com.denghb.zuiyou.domain.vo;

import com.denghb.zuiyou.domain.Rule;

/**
 * Created by denghb on 2017/4/17.
 */
public class RuleVo extends Rule {
    private String token;

    private Long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RuleVo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                "} " + super.toString();
    }
}
