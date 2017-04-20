package com.denghb.zuiyou.domain.vo;

import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.UserRuleAuth;

/**
 * Created by denghb on 2017/4/20.
 */
public class UserRuleAuthVo extends UserRuleAuth {

    private String username;

    private Rule rule;

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserRuleAuthVo{" +
                "username='" + username + '\'' +
                ", rule=" + rule +
                "} " + super.toString();
    }
}
