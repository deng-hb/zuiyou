package com.denghb.zuiyou.controller;


import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.criteria.HistoryCriteria;
import com.denghb.zuiyou.domain.History;
import com.denghb.zuiyou.model.Credential;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.HistoryService;
import com.denghb.zuiyou.utils.DataUtils;
import com.denghb.zuiyou.utils.ParameterUtils;
import com.denghb.zuiyou.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denghb on 2017/4/17.
 */
@RestController
@RequestMapping("/history")
public class HistoryController {

    private Logger log = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    HistoryService historyService;

    @RequestMapping("/create")
    public JsonModel create(@RequestBody History history) {
        JsonModel json = new JsonModel();
        try {
            historyService.create(history);
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
            HistoryCriteria criteria = new HistoryCriteria();
            ParameterUtils.initDataTablesParams(request, criteria);

            Credential credential = WebUtils.getCredential(request);

            PagingResult<History> result = historyService.list(credential, criteria);
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
