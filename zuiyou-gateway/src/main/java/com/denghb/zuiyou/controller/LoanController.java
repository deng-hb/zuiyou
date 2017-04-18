package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.service.LoanService;
import com.denghb.zuiyou.utils.JacksonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
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
    public String receive(HttpServletRequest request) {

        try {
            BufferedReader br = request.getReader();
            String str, wholeStr = "";
            while ((str = br.readLine()) != null) {
                wholeStr += str;
            }

            List<Loan> list = JacksonUtils.toList(wholeStr, Loan.class);

            for (Loan loan : list) {
                loanService.create(loan);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return "ok";
    }

}
