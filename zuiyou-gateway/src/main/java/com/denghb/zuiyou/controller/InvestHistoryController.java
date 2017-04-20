package com.denghb.zuiyou.controller;


import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.criteria.InvestHistoryCriteria;
import com.denghb.zuiyou.domain.InvestHistory;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.InvestHistoryService;
import com.denghb.zuiyou.utils.DataUtils;
import com.denghb.zuiyou.utils.ParameterUtils;
import com.denghb.zuiyou.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denghb on 2017/4/17.
 */
@RestController
@RequestMapping("/invest/history")
public class InvestHistoryController {

    private Logger log = LoggerFactory.getLogger(InvestHistoryController.class);

    @Autowired
    InvestHistoryService investHistoryService;

    @RequestMapping("/create")
    public JsonModel create(InvestHistory investHistory) {
        JsonModel json = new JsonModel();
        try {
            investHistoryService.create(investHistory);
            json.setMsg("创建成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.setMsg("创建失败");
        }
        return json;

    }


    @RequestMapping("/list")
    public JsonModel list(HttpServletRequest request) {
        JsonModel json = new JsonModel();
        try {
            InvestHistoryCriteria criteria = new InvestHistoryCriteria();
            ParameterUtils.initDataTablesParams(request, criteria);

            CurrentUser currentUser = WebUtils.getCurrentUser(request);

            PagingResult<InvestHistory> result = investHistoryService.list(currentUser, criteria);
            json.setData(DataUtils.pagingResult2DataTablesResult(result));
            json.setCode(1);
            json.setMsg("查询成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.setCode(0);
            json.setMsg("查询失败");
        }
        return json;

    }
}
