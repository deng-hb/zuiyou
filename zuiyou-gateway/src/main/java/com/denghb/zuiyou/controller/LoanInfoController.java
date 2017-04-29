package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.domain.LoanInfo;
import com.denghb.zuiyou.service.LoanInfoService;
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
public class LoanInfoController {

    private Logger log = LoggerFactory.getLogger(LoanInfoController.class);

    @Autowired
    private LoanInfoService loanInfoService;

    @RequestMapping("/loanInfo/receive")
    public String receive(@RequestBody List<LoanInfo> list) {

        try {
            for (LoanInfo loan : list) {
                loanInfoService.create(loan);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "ok";
    }

}
