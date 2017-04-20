package com.denghb.zuiyou.handler;

import com.denghb.zuiyou.domain.Pdu;
import com.denghb.zuiyou.handler.utils.HtmlUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by denghb on 2017/4/6.
 */
public class PduDetailHandler {
    private static final String PDU_KEY = "/user/";

    public Pdu execute(String url) {

        Connection connection = Jsoup.connect(url);
        connection.timeout(1000 * 30);
        Pdu pdu = new Pdu();
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
            return pdu;// 终止
        }

        // 剩余额度
        flag:
        for (Element element : document.select("#listRestMoney")) {
            String text = element.text();
            text = text.replaceAll("¥", "");
            text = text.replaceAll(",", "");
            pdu.setAuthBalance(new BigDecimal(text));
            break flag;
        }
        // pdu
        String id = HtmlUtils.getAttrForElements(document.select(".username"), "href");
        if (null != id) {
            int indexOf = id.indexOf(PDU_KEY);
            if (indexOf > -1) {
                id = id.substring(indexOf + PDU_KEY.length(), id.length());
                pdu.setPdu(id);
            }
        }

        // 魔镜等级
        flag:
        for (Element element : document.select(".creditRating")) {
            element.removeClass("creditRating");
            pdu.setGrade(element.className());
            break flag;
        }

        // 借款人信息
        flag:
        for (Element element : document.select(".lender-info")) {
            String html = element.text();
            String[] strings = html.split(" ");
            for (int i = 0; i < strings.length; i++) {
                String[] strs = strings[i].split("：");
                String value = strs[1];
                switch (i) {
                    case 0:
                        pdu.setSex("男".equals(value) ? 1 : 0);
                        break;
                    case 1:
                        pdu.setAge(Integer.valueOf(value));
                        break;
                    case 2:
                        pdu.setRegDate(value);
                        break;
                    case 3:
                        pdu.setEdu(value);
                        break;
                    case 4:
                        pdu.setSchool(value);
                        break;
                    case 5:
                        pdu.setStudyMode(value);
                        break;
                }
            }
            break flag;
        }

        // 认证信息
        flag:
        for (Element element : document.select(".record-info")) {
            String text = element.text();
            if (text.indexOf("学历认证") > -1) {
                pdu.setAuthEdu(true);
            }
            if (text.indexOf("身份证认证") > -1) {
                pdu.setAuthIdno(true);
            }
            if (text.indexOf("手机认证") > -1) {
                pdu.setAuthMobile(true);
            }
            break flag;
        }

        // 借款信息
        flag:
        for (Element element : document.select(".inner")) {
            String html = element.html();

            // 成功借款次数
            Pattern pattern = Pattern.compile("成功借款次数： <span class=\"num\">(\\d*)次</span>");
            Matcher matcher = pattern.matcher(html);
            if (matcher.find()) {
                pdu.setSuccLoanSize(Integer.valueOf(matcher.group(1)));
            }
            // 一次借款时间
            pattern = Pattern.compile("第一次成功借款时间： <span class=\"num\">(\\S*)</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                pdu.setFirstLoanDate(matcher.group(1));
            }

            // 历史记录
            pattern = Pattern.compile("历史记录： <span class=\"num\">(\\d*)次流标，(\\d*)次撤标，(\\d*)次失败</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                pdu.setUnLoanSize(Integer.valueOf(matcher.group(1)));
                pdu.setCancelLoanSize(Integer.valueOf(matcher.group(2)));
                pdu.setLoseLoanSize(Integer.valueOf(matcher.group(3)));
            }

            //
            pattern = Pattern.compile("成功还款次数：<span class=\"num\">(\\d*) 次</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                pdu.setSuccRepaySize(Integer.valueOf(matcher.group(1)));
            }

            // TODO
            pattern = Pattern.compile("正常还清次数：<span class=\"num\">(\\d*) 次</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
//                pduInfo.setSuccRepaySize(Integer.valueOf(matcher.group(1)));
            }

            //
            pattern = Pattern.compile("逾期(0-15天)还清次数：<span class=\"num\">(\\d*) 次</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                pdu.setDelayLt15RepaySize(Integer.valueOf(matcher.group(1)));
            }

            //
            pattern = Pattern.compile("逾期(15天以上)还清次数：<span class=\"num\">(\\d*) 次</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                pdu.setDelayGt15RepaySize(Integer.valueOf(matcher.group(1)));
            }

            //
            pattern = Pattern.compile("累计借款金额：<span class=\"num\">¥(\\S*)</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                String str = matcher.group(1);
                str = str.replaceAll(",", "");
                pdu.setTotalLoanAmount(new BigDecimal(str));
            }
            //
            pattern = Pattern.compile("待还金额：<span class=\"num\">¥(\\S*)</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                String str = matcher.group(1);
                str = str.replaceAll(",", "");
                pdu.setWaitRepayAmount(new BigDecimal(str));
            }
            //
            pattern = Pattern.compile("待收金额： <span class=\"num\"> ¥(\\S*) </span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                String str = matcher.group(1);
                str = str.replaceAll(",", "");
                pdu.setWaitCollectAmount(new BigDecimal(str));
            }
            //
            pattern = Pattern.compile("单笔最高借款金额：<span class=\"num\">¥(\\S*)</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                String str = matcher.group(1);
                str = str.replaceAll(",", "");
                pdu.setSingleMaxLoanAmount(new BigDecimal(str));
            }
            //
            pattern = Pattern.compile("历史最高负债：<span class=\"num\">¥(\\S*)</span>");
            matcher = pattern.matcher(html);
            if (matcher.find()) {
                String str = matcher.group(1);
                str = str.replaceAll(",", "");
                pdu.setHistoryHighOwe(new BigDecimal(str));
            }
            //
            break flag;
        }
        return pdu;

    }

}
