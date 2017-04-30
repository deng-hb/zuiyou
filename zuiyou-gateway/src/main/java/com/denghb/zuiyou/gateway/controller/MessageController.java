package com.denghb.zuiyou.gateway.controller;

import com.denghb.zuiyou.gateway.model.JsonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by denghb on 2017/4/29.
 */
@RestController
public class MessageController {

    private Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/cmd")
    @ResponseBody
    public JsonModel cmd(String value){
        simpMessagingTemplate.convertAndSend("/topic/notice", value);


        return JsonModel.buildSuccess("ok");
    }

    /**
     *
     */
    @MessageMapping("/message")
    public void message(String value) {
        log.info("client:{}", value);
        simpMessagingTemplate.convertAndSend("/topic/notice", value);

    }
}
