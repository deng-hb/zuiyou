package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.model.StatInfo;
import com.denghb.zuiyou.service.LoanService;
import com.denghb.zuiyou.service.PduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by denghb on 2017/4/8.
 */
@RestController
public class IndexController {

    @Autowired
    PduService pduInfoService;
    @Autowired
    LoanService loanInfoService;

    @RequestMapping("/")
    public StatInfo index() {
        StatInfo info = new StatInfo();

        info.setLoanCount(loanInfoService.count());
        info.setPduCount(pduInfoService.count());
        info.setTotalAmount(loanInfoService.totalAmount());
        return info;
    }

}
