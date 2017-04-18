package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.domain.Pdu;
import com.denghb.zuiyou.service.PduService;
import com.denghb.zuiyou.utils.JacksonUtils;
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
public class PduController {

    @Autowired
    private PduService pduService;

    @RequestMapping("/pdu/receive")
    public String receive(HttpServletRequest request) {

        try {
            BufferedReader br = request.getReader();
            String str, wholeStr = "";
            while ((str = br.readLine()) != null) {
                wholeStr += str;
            }

            System.out.println(wholeStr);
            List<Pdu> list = JacksonUtils.toList(wholeStr, Pdu.class);

            for (Pdu pdu : list) {
                pduService.create(pdu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
