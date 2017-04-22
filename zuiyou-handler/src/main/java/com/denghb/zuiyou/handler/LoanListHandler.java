package com.denghb.zuiyou.handler;

import com.denghb.zuiyou.domain.Loan;
import com.denghb.zuiyou.handler.utils.HtmlUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denghb on 2017/4/6.
 */
public class LoanListHandler implements Runnable {

    public interface LoanListHandlerCallback {
        void list(List<Loan> list);
    }

    private Logger log = LoggerFactory.getLogger(LoanListHandler.class);

    static String PPDAI_LOANLIST_URL = "http://invest.ppdai.com/loan/listnew?LoanCategoryId=%d&PageIndex=%d";

    private static final String PDU_KEY = "/user/";
    private static final String LOAN_KEY = "id=";
    private LoanListHandlerCallback callback;


    private static String THREAD_NAME = "thread-loan-";
    private int type;
    private int total = 0;
    private int page = 1;

    public LoanListHandler(int type) {
        this.type = type;
    }


    @Override
    public void run() {
        execute();
    }

    private void execute() {
        log.info("execute type:{},page:{} ", type, page);

        List<Loan> list = new ArrayList<Loan>();

        String url = String.format(PPDAI_LOANLIST_URL, type, page);

        Connection connection = Jsoup.connect(url);
        connection.timeout(1000 * 30);

        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        // 获取当前标的数
        for (Element element : document.select(".sp_num_col")) {
            String num = element.text();
            total = Integer.parseInt(num);
            break;
        }

        // 获取列表
        for (Element element : document.select(".wapBorrowList")) {

            Loan loan = null;
            // 标的列表
            for (Element element1 : element.getElementsByTag("ol")) {

                loan = new Loan();

                // 魔镜等级
                flag:
                for (Element element2 : document.select(".creditRating")) {
                    element2.removeClass("creditRating");
                    String s = element2.className();
                    loan.setGrade(element2.className());
                    break flag;
                }

                for (Element element2 : element1.select(".listtitle")) {

                    flag:
                    for (Element element3 : element2.getElementsByTag("a")) {
                        // 标的地址
                        String href = element3.attr("href");
                        loan.setUrl(href);

                        int i = href.indexOf(LOAN_KEY);
                        if (i > -1) {
                            // ID
                            String id = href.substring(i + LOAN_KEY.length(), href.length());
                            loan.setId(Integer.valueOf(id));
                            // 获取标题
                            loan.setTitle(element3.attr("title"));

                        }
                        break flag;
                    }

                    // 获取用户地址
                    for (Element element3 : element2.select(".userInfo")) {
                        String href = HtmlUtils.getAttrForElements(element3.getElementsByTag("a"), "href");

                        int i = href.indexOf(PDU_KEY);
                        if (i > -1) {
                            String pdu = href.substring(i + PDU_KEY.length(), href.length());
                            loan.setPdu(pdu);
                        }
                        loan.setPduUrl(href);

                        // 赔
                        for (Element element4 : element3.select(".pei")) {
                            loan.setIsPei(true);
                        }
                        // 预审
                        for (Element element4 : element3.select(".yushen")) {
                            loan.setIsYushen(true);
                        }
                    }


                }

                // 认证情况
                for (Element element2 : element1.select(".cert")) {
                    // 学历认证
                    for (Element element3 : element2.select(".record")) {
                        loan.setAuthEdu(true);
                    }
                    // 手机认证
                    for (Element element3 : element2.select(".phone")) {
                        loan.setAuthMobile(true);
                    }
                    // 户籍认证
                    for (Element element3 : element2.select(".hukou")) {
                        loan.setAuthRegister(true);
                    }
                    // 人行征信认证
                    for (Element element3 : element2.select(".renbankcredit")) {
                        loan.setAuthRenBank(true);
                    }
                    // 视频认证
                    for (Element element3 : element2.select(".video")) {
                        loan.setAuthVideo(true);
                    }
                    // 身份证默认都是认证的
                }

                // 金额
                for (Element element2 : element1.select(".sum")) {
                    String amount = element2.text();
                    amount = amount.replaceAll("¥", "");
                    amount = amount.replaceAll(",", "");
                    // TODO 金额
                    try {
                        loan.setAmount(new BigDecimal(amount));
                    } catch (Exception e) {
                    }
                }

                // 期限
                for (Element element2 : element1.select(".limitTime")) {

                    String limit = element2.text();

                    limit = HtmlUtils.getNumber(limit);
                    loan.setLimit(Integer.valueOf(limit));
                }

                // 利率
                String rate = element1.select(".brate").text();
                rate = rate.replaceAll("%", "");
                loan.setRate(new BigDecimal(rate));


                list.add(loan);
            }
        }

        if (null != callback) {
            callback.list(list);
        }
        // 递归
        if (total >= 10 * ++page) {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            execute();
        }

    }

    public LoanListHandlerCallback getCallback() {
        return callback;
    }

    public void setCallback(LoanListHandlerCallback callback) {
        this.callback = callback;
    }
}
