package com.denghb.zuiyou.openapi.task;


import com.denghb.zuiyou.openapi.handler.LoanInfoHandler;
import com.ppdai.open.core.OpenApiClient;
import com.ppdai.open.core.RsaCryptoHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(2);


    private boolean isInit;

    @Value("${openapi.appId}")
    private String appId;
    @Value("${openapi.serverPublicKey}")
    private String serverPublicKey;
    @Value("${openapi.clientPrivateKey}")
    private String clientPrivateKey;

    public ScheduledTasks() {

    }

    @Scheduled(fixedRate = 5000)
    public void run() {
        init();

        LoanInfoHandler loanListHandler = new LoanInfoHandler();

        executorService.submit(loanListHandler);
    }

    private void init() {
        if (isInit) {
            return;
        }
        //初始化操作
        try {
            OpenApiClient.Init(appId, RsaCryptoHelper.PKCSType.PKCS8, serverPublicKey, clientPrivateKey);
            isInit = true;
            log.info("OpenApiClient.Init success");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}