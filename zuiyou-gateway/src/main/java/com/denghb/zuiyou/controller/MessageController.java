package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.model.JsonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * Created by denghb on 2017/4/29.
 */
@EnableWebSocketMessageBroker
@RestController
public class MessageController {

    private Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/cmd")
    @ResponseBody
    public JsonModel cmd(String value){
        JsonModel json = new JsonModel();
        simpMessagingTemplate.convertAndSend("/topic/notice", value);
        json.setCode(1);
        json.setMsg("ok");
        return json;
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
