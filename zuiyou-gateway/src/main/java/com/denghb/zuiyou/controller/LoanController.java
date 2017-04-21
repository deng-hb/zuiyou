package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ppd on 2017/4/12.
 */
@RestController
public class LoanController {

    private Logger log = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;

    @RequestMapping("/loan/receive")
    public String receive(@RequestBody List<Loan> list) {

        try {
            for (Loan loan : list) {
                loanService.create(loan);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "ok";
    }

}
