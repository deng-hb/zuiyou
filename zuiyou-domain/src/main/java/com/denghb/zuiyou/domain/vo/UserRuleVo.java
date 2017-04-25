package com.denghb.zuiyou.domain.vo;

import com.denghb.zuiyou.domain.Rule;

/**
 * Created by denghb on 2017/4/17.
 */
public class UserRuleVo extends Rule {

    private String token;

    private Long userId;

    private String pdu;

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

    public String getPdu() {
        return pdu;
    }

    public void setPdu(String pdu) {
        this.pdu = pdu;
    }

    @Override
    public String toString() {
        return "UserRuleVo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                ", pdu='" + pdu + '\'' +
                "} " + super.toString();
    }
}
