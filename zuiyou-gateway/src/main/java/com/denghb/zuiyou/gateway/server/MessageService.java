package com.denghb.zuiyou.gateway.server;

import org.springframework.messaging.Message;
import org.springframework.messaging.core.AbstractMessageSendingTemplate;

/**
 * Created by denghb on 2017/4/30.
 */
public class MessageService  extends AbstractMessageSendingTemplate<String> {
    @Override
    protected void doSend(String destination, Message<?> message) {

    }
}
