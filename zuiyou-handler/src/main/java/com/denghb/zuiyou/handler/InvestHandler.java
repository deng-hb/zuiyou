package com.denghb.zuiyou.handler;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.data.RuleVoData;
import com.denghb.zuiyou.domain.InvestHistory;
import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.domain.Pdu;
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
 * Created by denghb on 2017/4/17.
 */
public class InvestHandler {

    private Logger log = LoggerFactory.getLogger(InvestHandler.class);

    private String INVEST_URL = "http://invest.ppdai.com/bid/info?listingId=%d&money=%d";

    public InvestHandler(Loan loan, Pdu pdu) {

        // 分析标的
        List<RuleVo> rules = RuleVoData.getList();
        for (RuleVo vo : rules) {
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
    private boolean compare(RuleVo rule, Loan loan, Pdu pdu) {
        // 比最小还小
        if (null == rule.getLimitMin() || rule.getLimitMin().intValue() > loan.getLimit().intValue()) {
            return false;
        }
        // 比最大还大
        if (null == rule.getLimitMax() || rule.getLimitMax().intValue() < loan.getLimit().intValue()) {
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
    private void run(RuleVo rule, Loan loan, Pdu pdu) {
        String url = String.format(INVEST_URL, loan.getId(), rule.getAmount().intValue());
        Connection connection = Jsoup.connect(url);
        connection.header("Cookie", rule.getAuth());
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        InvestHistory investHistory = new InvestHistory();

        for (Element element : document.select(".lend_detail_biderror")) {
            String remarks = element.text();
            investHistory.setRemarks(remarks);
            log.info(element.text());
            break;
        }

        Map<String, String> map = new HashMap<>();
        map.put("remarks", investHistory.getRemarks());
        map.put("pdu", pdu.getPdu());
        map.put("userId", rule.getUserId().toString());
        map.put("loanId", loan.getId().toString());
        HttpUtils.post(Constants.Server.INVEST_HISTORY_CREATE_URL, map);
    }
}
