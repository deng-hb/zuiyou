package com.denghb.zuiyou.gateway.controller;

import com.denghb.zuiyou.domain.Pdu;
import com.denghb.zuiyou.gateway.model.JsonModel;
import com.denghb.zuiyou.gateway.service.PduService;
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
public class PduController {

    private Logger log = LoggerFactory.getLogger(PduController.class);

    @Autowired
    private PduService pduService;

    @RequestMapping("/pdu/receive")
    public JsonModel receive(@RequestBody List<Pdu> list) {

        try {
            for (Pdu pdu : list) {
                pduService.create(pdu);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return JsonModel.buildSuccess("ok");
    }
}
