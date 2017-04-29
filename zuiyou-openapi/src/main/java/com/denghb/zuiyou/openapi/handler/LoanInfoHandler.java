package com.denghb.zuiyou.openapi.handler;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.openapi.domain.LoanDetail;
import com.denghb.zuiyou.openapi.domain.LoanInfo;
import com.denghb.zuiyou.openapi.utils.LoanUtils;
import com.denghb.zuiyou.utils.HttpUtils;
import com.denghb.zuiyou.utils.JacksonUtils;
import com.ppdai.open.core.OpenApiClient;
import com.ppdai.open.core.PropertyObject;
import com.ppdai.open.core.Result;
import com.ppdai.open.core.ValueTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by denghb on 2017/4/29.
 */
public class LoanInfoHandler implements Runnable {

    private static Logger log = LoggerFactory.getLogger(LoanInfoHandler.class);

    private Map<Integer, LoanInfo> loanInfoMap = new HashMap<>();

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
            return;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            LoanInfo loanInfo = list.get(i);
            Integer id = loanInfo.getId();

            LoanUtils.setId(id);

            loanInfoMap.put(id, loanInfo);
        }


        // 排重
        List<Integer> data = LoanUtils.getNewIds();
        if (null == data || data.isEmpty()) {
            log.info("load all id:[{}],new id:[{}]", size, 0);
            return;
        }

        int dataSize = data.size();
        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 0; i < dataSize; i++) {

            ids.add(data.get(i));

            if ((i + 1) % 10 == 0) {
                loadDetail(ids);
                ids = new ArrayList<Integer>();
            }

            // 最后几个
            if (i == size - 1 && !ids.isEmpty()) {
                loadDetail(ids);
            }
        }

        log.info("load all id:[{}],new id:[{}]", size, dataSize);

    }

    private void loadDetail(List<Integer> listIds) throws Exception {
        //请求url
        String url = "http://gw.open.ppdai.com/invest/LLoanInfoService/BatchListingInfos";
        Result result = OpenApiClient.send(url, new PropertyObject("ListingIds", listIds, ValueTypeEnum.Other));
        String content = result.getContext();

        content = content.substring(content.indexOf("["), content.indexOf("]") + 1);


        List<LoanDetail> list = JacksonUtils.toList(content, LoanDetail.class);

        for (LoanDetail detail : list) {
            LoanInfo loanInfo = loanInfoMap.get(detail.getId());
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
