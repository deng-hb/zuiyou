package com.denghb.zuiyou.handler.server;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.business.data.UserRuleVoData;
import com.denghb.zuiyou.domain.History;
import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.domain.Pdu;
import com.denghb.zuiyou.domain.vo.UserRuleVo;
import com.denghb.zuiyou.common.utils.HttpUtils;
import com.denghb.zuiyou.common.utils.NumberUtils;
import com.denghb.zuiyou.common.utils.JacksonUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
public class InvestHandler {

    private static Logger log = LoggerFactory.getLogger(InvestHandler.class);

    private static String INVEST_URL = "http://invest.ppdai.com/bid/info?listingId=%d&money=%d";

    public InvestHandler(Loan loan, Pdu pdu) {

        // 分析标的
        List<UserRuleVo> rules = UserRuleVoData.getList();
        for (UserRuleVo vo : rules) {
            boolean b = compare(vo, loan, pdu);
            if (b) {
                run(vo, loan, pdu);
            }
        }

    }

    /**
     * 规则比较
     *
     * @param rule
     * @param loan
     * @param pdu
     * @return
     */
    private boolean compare(UserRuleVo rule, Loan loan, Pdu pdu) {
        // 期限
        if (!NumberUtils.between(rule.getLimitMin(), loan.getLimit(), rule.getLimitMax())) {
            return false;
        }
        // 利率
        if (!NumberUtils.between(rule.getRateMin(), loan.getRate(), rule.getLimitMax())) {
            return false;
        }
        return true;
    }

    /**
     * 执行投标
     *
     * @param rule
     * @param loan
     * @param pdu
     */
    private void run(UserRuleVo rule, Loan loan, Pdu pdu) {
        History history = new History();
        String url = String.format(INVEST_URL, loan.getId(), rule.getAmount().intValue());
        Connection connection = Jsoup.connect(url);
        // 这样就登录了。。。。
        connection.header("Cookie", rule.getToken());
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            history.setRemarks(e.getMessage());
            log.error(e.getMessage());
        }

        for (Element element : document.select(".lend_detail_biderror")) {
            String remarks = element.text();
            history.setRemarks(remarks);
            log.info(element.text());
            break;
        }
        history.setPdu(pdu.getPdu());
        history.setUserId(rule.getUserId());
        history.setLoanId(loan.getId());
        history.setTitle(loan.getTitle());
        history.setRuleId(rule.getId());
        String body = JacksonUtils.toJson(history);
        HttpUtils.send(Constants.Server.INVEST_HISTORY_CREATE_URL, body);
    }

    public static void main(String[] args) {
        Connection connection = Jsoup.connect("http://www.ppdai.com/user/pdu4248118068");
        connection.header("Cookie", "authid=98315E594BF26C87716AC20701589F401B5B462D98031539D9E285141392530BC961C1A85F4522D1D2DBE983F20880722855AA898A30B5B238A3321988C3B6CED28FB47FBAE8C8E59B8C0BC25828471D8CF1B5E3F7C9FF53D76AFE4EE2B3CC1E80CCF2B1A8FF0C08A82C35B3972E06B6B8899D4010E1521A501228EE11CC9BF923BC689621BBD25536D18208886753F6E73D640A2A907142626D00EF5F09D23DAD7235B17859F03997C5A55C77989B0367EA5A2D; token=192ed2ac-1b99-4ddc-b687-ab318238364d; ");
        Document document = null;
        try {
            document = connection.get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
