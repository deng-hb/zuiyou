package com.denghb.zuiyou.crawler.task;


import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.domain.Pdu;
import com.denghb.zuiyou.crawler.server.InvestHandler;
import com.denghb.zuiyou.crawler.server.LoanListHandler;
import com.denghb.zuiyou.crawler.server.PduDetailHandler;
import com.denghb.zuiyou.common.utils.HttpUtils;
import com.denghb.zuiyou.common.utils.JacksonUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    private ExecutorService executorService2 = Executors.newFixedThreadPool(2);

    static String PPDAI_USER_URL = "http://www.ppdai.com/user/%s";

    public ScheduledTasks() {

    }

    // 低风险
    // http://invest.ppdai.com/MiddleUser/index?user=ppd_sys_ddup18mu0044
    @Scheduled(fixedRate = 5000)
    public void run1() {

        LoanListHandler loanListHandler = new LoanListHandler(8);
        loanListHandler.setCallback(new LoanListHandler.LoanListHandlerCallback() {
            @Override
            public void list(List<Loan> list) {
                handler(list);
            }
        });
        executorService.submit(loanListHandler);
    }


    // 中风险
    @Scheduled(fixedRate = 4000)
    public void run2() {
        run(4);
    }

    // 高风险
    @Scheduled(fixedRate = 3000)
    public void run3() {
        run(5);
    }

    private void run(int type) {

        LoanListHandler loanListHandler = new LoanListHandler(type);
        loanListHandler.setCallback(new LoanListHandler.LoanListHandlerCallback() {
            @Override
            public void list(List<Loan> list) {
                handler(list);
            }
        });
        executorService2.submit(loanListHandler);

    }

    public void handler(List<Loan> list) {
        List<Pdu> pduList = new ArrayList<>();
        for (Loan loan : list) {
            if (null == loan || null == loan.getId()) {
                continue;
            }

            Pdu pdu = new PduDetailHandler().execute(loan.getUrl());
            pduList.add(pdu);

            // 筛选并投标并记录
            new InvestHandler(loan, pdu);
        }

        // TODO 异步？
        String json1 = JacksonUtils.toJson(list);
        HttpUtils.send(Constants.Server.LOAN_RECEIVE_URL, json1);

        String json2 = JacksonUtils.toJson(pduList);
        HttpUtils.send(Constants.Server.PDU_RECEIVE, json2);
    }


    public void run4() {
        Connection connection = Jsoup.connect(PPDAI_USER_URL);
        connection.header("Cookie", "aliyungf_tc=AQAAAEDN7ks0PAIAiDxAcF1stU+l+0jf; uniqueid=4d9b461f-6155-42b6-8bd8-fbb29d86b5c9; regSourceId=0; referID=0; fromUrl=; referDate=2017-4-10%2022%3A50%3A10; currentUrl=https%3A%2F%2Fac.ppdai.com%2Fuser%2Flogin%3Fredirect%3Dhttp%3A%2F%2Floan.ppdai.com%2Faccount%2Fborrow; Hm_lvt_f87746aec9be6bea7b822885a351b00f=1491393160,1491835810; Hm_lpvt_f87746aec9be6bea7b822885a351b00f=1491835810; _ppdaiWaterMark=14918358117224; authid=9F799CF7D01F37365922D0360179B6C1227D6F3A8B8757E95241B846D3C0AB4E03CDD9504F1854B5C30969A8C318DBBC3E17E3EF8ECB4C6EC25E35CD492DF3371A359DDA70428912C3EA6FAAA946177A704C8D8F8416E55C97B7DBEF3D155EC7DF1C067277CF6BD2A8BCDA10E89D489956295FACEA8482C64FFFE2D68B776A78A20289E74BB7D0E80439C3C1CC0D85182E82CCB96D68B326B9E4F60F2EB0831D3DFED2F94C0EF24DDA6BE980C2D01E509C4992E8; token=a9c6ba45-ece6-4056-9d75-742f5dc1f677; __eui=ysLug0IWNxw%3d; ppd_uname=pdu70267712");
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        System.out.println(document);
    }

}