package com.denghb.zuiyou.gateway.service;


import com.denghb.zuiyou.domain.Pdu;

/**
 * Created by denghb on 2017/4/7.
 */
public interface PduService {

    void create(Pdu pdu);

    int count();
}
