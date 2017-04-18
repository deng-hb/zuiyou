package com.denghb.zuiyou.domain.vo;

import com.denghb.zuiyou.domain.Rule;

/**
 * Created by denghb on 2017/4/17.
 */
public class RuleVo extends Rule {
    private String auth;

    private Long userId;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
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
                "auth='" + auth + '\'' +
                ", userId=" + userId +
                "} " + super.toString();
    }
}
