package com.denghb.zuiyou.gateway.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.domain.LoanInfo;
import com.denghb.zuiyou.gateway.service.LoanInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * Created by denghb on 2017/4/29.
 */
@Service
public class LoanInfoServiceImpl implements LoanInfoService {

    private static Logger log = LoggerFactory.getLogger(LoanInfoServiceImpl.class);

    @Autowired
    private DbHelper db;

    @Override
    public void create(LoanInfo loanInfo) {
        if (null == loanInfo || null == loanInfo.getId()) {
            return;
        }
        try {
            db.insert(loanInfo);
        } catch (DataIntegrityViolationException e) {
            log.warn("loan info:[{}] exist", loanInfo.getId());
        }
    }
}
