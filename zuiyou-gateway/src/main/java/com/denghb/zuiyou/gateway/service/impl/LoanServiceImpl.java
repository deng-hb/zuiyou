package com.denghb.zuiyou.gateway.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.gateway.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/7.
 */
@Service
public class LoanServiceImpl implements LoanService {

    private static Logger log = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Autowired
    private DbHelper db;

    @Override
    @Transactional
    public void create(Loan loan) {
        if (null == loan || null == loan.getId()) {
            return;
        }
        try {
            db.insert(loan);
        } catch (DataIntegrityViolationException e) {
            log.warn("loan:[{}] exist", loan.getId());
        }
    }

    @Override
    public int count() {
        return db.queryForObject("select count(*) from loan", Integer.class);
    }

    @Override
    public BigDecimal totalAmount() {
        return db.queryForObject("select sum(amount) from loan", BigDecimal.class);
    }
}
