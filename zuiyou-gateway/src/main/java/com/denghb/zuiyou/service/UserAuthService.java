package com.denghb.zuiyou.service;


import com.denghb.zuiyou.domain.vo.UserAuthVo;
import com.denghb.zuiyou.exception.ZuiyouException;
import com.denghb.zuiyou.model.Credential;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/11.
 */
public interface UserAuthService {


    /**
     * 绑定用户
     *
     * @param credential
     * @param pdu
     * @param token
     */
    void bind(Credential credential, String pdu, String token);

    /**
     * 获取用户绑定信息
     *
     * @param credential
     * @return
     */
    UserAuthVo queryUserAuthInfo(Credential credential);


    /**
     * 开启投标
     *
     * @param currentUser
     */
    void open(Credential currentUser);

    /**
     * 关闭投标
     *
     * @param currentUser
     */
    void close(Credential currentUser);

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
