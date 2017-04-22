package com.denghb.zuiyou.service;


import com.denghb.zuiyou.domain.vo.UserRuleAuthVo;
import com.denghb.zuiyou.exception.ZuiyouException;
import com.denghb.zuiyou.model.CurrentUser;

import java.math.BigDecimal;

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

    /**
     * 获取用户绑定信息
     *
     * @param currentUser
     * @return
     */
    UserRuleAuthVo queryUserRuleAuthInfo(CurrentUser currentUser);


    /**
     * 开启投标
     *
     * @param currentUser
     */
    void open(CurrentUser currentUser);

    /**
     * 关闭投标
     *
     * @param currentUser
     */
    void close(CurrentUser currentUser);

    /**
     * 更新指定PDU的余额
     *
     * @param pdu
     * @param balance
     */
    void updateBalance(String pdu, BigDecimal balance) throws ZuiyouException;

    /**
     * 授权失效
     *
     * @param pdu
     */
    void invalid(String pdu) throws ZuiyouException;
}
