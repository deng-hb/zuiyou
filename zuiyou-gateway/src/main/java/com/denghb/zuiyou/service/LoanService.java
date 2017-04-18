package com.denghb.zuiyou.service;

import com.denghb.zuiyou.domain.Loan;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/7.
 */
public interface LoanService {
    void create(Loan loan);

    int count();

    BigDecimal totalAmount();
}
