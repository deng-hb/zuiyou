package com.denghb.zuiyou.handler.client;


import com.denghb.zuiyou.business.data.UserRuleVoData;
import com.denghb.zuiyou.common.Constants;
import com.ppdai.open.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by denghb on 2017/4/29.
 */
@Component
public class Client {

    private Logger log = LoggerFactory.getLogger(Client.class);

    private static final String url = String.format("ws://%s/socket", Constants.Server.GATEWAY_HOST);

    private WebSocketStompClient stompClient;

    public Client() {

        List<Transport> transports = new ArrayList<Transport>(2);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient = new SockJsClient(transports);
//        sockJsClient.doHandshake(new MyWebSocketHandler(), url);// 握手

        stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        stompClient.setDefaultHeartbeat(new long[]{0, 0});
        // stompClient.setTaskScheduler(taskScheduler); // for heartbeats

        connection();

    }

    private void connection() {

        stompClient.connect(url, new StompSessionHandlerAdapter() {
            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                super.afterConnected(session, connectedHeaders);

                session.subscribe("/topic/notice", new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return String.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        // ...

                        System.out.println(payload);
                        if (Constants.Command.SYSTEM_EXIT.equals(payload)) {
                            System.exit(9);
                        }
                        if (Constants.Command.UPDATE_RULE.equals(payload)) {
                            UserRuleVoData.pull();
                        }
                    }
                });

                session.subscribe("/topic/authorize", new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return String.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        String code = payload.toString();
                        try {
                            AuthInfo authInfo = OpenApiClient.authorize(code);
                            System.out.println(authInfo);

                            String accessToken = authInfo.getAccessToken();
                            //请求url
                            String url = "http://gw.open.ppdai.com/auth/LoginService/AutoLogin";
                            Result result = OpenApiClient.send(url, accessToken
                                    , new PropertyObject("Timestamp", new Date(), ValueTypeEnum.DateTime));
                            System.out.println(String.format("返回结果:%s", result.isSucess() ? result.getContext() : result.getErrorMessage()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                session.subscribe("/topic/refreshToken", new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return String.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        String data = payload.toString();
                        String[] strs = data.split("|");
                        try {
                            AuthInfo authInfo = OpenApiClient.refreshToken(strs[0], strs[1]);
                            System.out.println(authInfo);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                session.send("/app/message", "openapi");
            }

            @Override
            public void handleTransportError(StompSession session, Throwable exception) {
                super.handleTransportError(session, exception);
                // 链接失败
                connection();
            }
        });
    }
}
