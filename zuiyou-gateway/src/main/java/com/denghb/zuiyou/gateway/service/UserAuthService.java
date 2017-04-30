package com.denghb.zuiyou.gateway.service;


import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.domain.UserAuth;
import com.denghb.zuiyou.gateway.criteria.UserAuthCriteria;
import com.denghb.zuiyou.gateway.exception.ZuiyouException;
import com.denghb.zuiyou.gateway.model.Credential;

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
     * 开启投标
     *
     * @param credential
     */
    void open(Credential credential,String pdu);

    /**
     * 关闭投标
     *
     * @param credential
     */
    void close(Credential credential,String pdu);

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

    /**
     * 用户列表
     *
     * @param credential
     * @param criteria
     * @return
     */
    PagingResult<UserAuth> list(Credential credential, UserAuthCriteria criteria);
}
