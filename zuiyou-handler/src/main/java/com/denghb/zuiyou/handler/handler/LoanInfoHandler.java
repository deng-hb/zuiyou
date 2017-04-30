package com.denghb.zuiyou.handler.handler;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.common.utils.HttpUtils;
import com.denghb.zuiyou.handler.domain.LoanDetail;
import com.denghb.zuiyou.handler.domain.LoanInfo;
import com.denghb.zuiyou.handler.utils.LoanUtils;
import com.denghb.zuiyou.common.utils.JacksonUtils;
import com.ppdai.open.core.OpenApiClient;
import com.ppdai.open.core.PropertyObject;
import com.ppdai.open.core.Result;
import com.ppdai.open.core.ValueTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denghb on 2017/4/29.
 */
public class LoanInfoHandler implements Runnable {

    private static Logger log = LoggerFactory.getLogger(LoanInfoHandler.class);

    @Override
    public void run() {
        try {
            next();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void next() throws Exception {
        //请求url
        String url = "http://gw.open.ppdai.com/invest/LLoanInfoService/LoanList";
        Result result = OpenApiClient.send(url, new PropertyObject("PageIndex", 1, ValueTypeEnum.Int32));

        String content = result.getContext();

        content = content.substring(content.indexOf("["), content.indexOf("]") + 1);


        List<LoanInfo> list = JacksonUtils.toList(content, LoanInfo.class);

        if (null == list || list.isEmpty()) {
            outLog(0, 0);
            return;
        }
        // 初始化
        LoanUtils.init(list);

        int allSize = list.size();

        // 新的ID排重
        List<Integer> data = LoanUtils.getNewIds();
        if (null == data || data.isEmpty()) {
            outLog(allSize, 0);
            return;
        }

        int newSize = data.size();
        outLog(allSize, newSize);

        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 0; i < newSize; i++) {

            ids.add(data.get(i));

            if ((i + 1) % 10 == 0) {
                loadDetail(ids);
                ids = new ArrayList<Integer>();
            }

            // 最后几个
            if (i == newSize - 1 && !ids.isEmpty()) {
                loadDetail(ids);
            }
        }

    }

    private void outLog(int allSize, int newSize) {

        log.info("load all id:[{}],new id:[{}]", allSize, newSize);
    }

    private void loadDetail(List<Integer> listIds) throws Exception {
        //请求url
        String url = "http://gw.open.ppdai.com/invest/LLoanInfoService/BatchListingInfos";
        Result result = OpenApiClient.send(url, new PropertyObject("ListingIds", listIds, ValueTypeEnum.Other));
        String content = result.getContext();

        content = content.substring(content.indexOf("["), content.indexOf("]") + 1);


        List<LoanDetail> list = JacksonUtils.toList(content, LoanDetail.class);

        for (LoanDetail detail : list) {
            LoanInfo loanInfo = LoanUtils.getLoanInfo(detail.getId());
            if (null == loanInfo) {
                log.info("null id:[{}]", detail.getId());
                continue;
            }
            detail.setTitle(loanInfo.getTitle());
            detail.setPayWay(loanInfo.getPayWay());
        }

        // 将这些ID
        LoanUtils.useIds(listIds);
        // 匹配投标

        String json = JacksonUtils.toJson(list);
        HttpUtils.send(Constants.Server.LOAN_INFO_RECEIVE, json);
    }

}
