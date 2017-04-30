package com.denghb.zuiyou.gateway.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.domain.Pdu;
import com.denghb.zuiyou.gateway.service.PduService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by denghb on 2017/4/7.
 */
@Service
public class PduServiceImpl implements PduService {

    private static Logger log = LoggerFactory.getLogger(PduServiceImpl.class);

    @Autowired
    private DbHelper db;

    @Override
    @Transactional
    public void create(Pdu pdu) {
        if (null == pdu || null == pdu.getPdu()) {
            return;
        }
        try {
            db.insert(pdu);
        } catch (DataIntegrityViolationException e) {
            log.warn("pdu:[{}] exist", pdu.getPdu());
        }
    }

    @Override
    public int count() {
        return db.queryForObject("select count(*) from pdu", Integer.class);
    }
}
