package com.denghb.zuiyou.handler;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.data.RuleVoData;
import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.utils.HttpUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by denghb on 2017/4/22.
 */
public class BalanceHandler implements Runnable {

    private final Logger log = LoggerFactory.getLogger(BalanceHandler.class);

    @Override
    public void run() {

        log.info("balance update execute");

        List<RuleVo> list = RuleVoData.getList();

        for (RuleVo vo : list) {
            String pdu = vo.getPdu();
            log.info("pdu[{}] balance update execute", pdu);

            Connection connection = Jsoup.connect("http://invest.ppdai.com/loan/listnew");
            connection.header("Cookie", vo.getToken());
            Document document = null;
            try {
                document = connection.get();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }


            String balance = null;

            for (Element element : document.select(".sp_num")) {
                String amount = element.text();
                balance = amount.replaceAll("¥", "");
            }

            if (null == balance) {
                // 授权失败需要重新授权
                log.info("pdu[{}] auth invalid", pdu);

                HttpUtils.get(Constants.Server.AUTH_INVALID + "?pdu=" + pdu);
            } else {

                Map<String, String> param = new HashMap<>();
                param.put("pdu", pdu);
                param.put("balance", balance);

                String res = HttpUtils.post(Constants.Server.UPDATE_BALANCE, param);

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    public static void main(String[] args) {


        new BalanceHandler().run();
    }
}
