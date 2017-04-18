package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.model.StatInfo;
import com.denghb.zuiyou.server.NioServer;
import com.denghb.zuiyou.service.LoanService;
import com.denghb.zuiyou.service.PduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/cmd")
    public String cmd(HttpServletRequest request) {
        String cmd = request.getParameter("cmd");
        NioServer.sendCommand(cmd);
        return "ok";
    }
}
