package com.denghb.zuiyou.gateway.controller;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.vo.UserRuleVo;
import com.denghb.zuiyou.gateway.criteria.RuleCriteria;
import com.denghb.zuiyou.gateway.model.Credential;
import com.denghb.zuiyou.gateway.model.DataTablesResult;
import com.denghb.zuiyou.gateway.model.JsonModel;
import com.denghb.zuiyou.gateway.service.UserRuleService;
import com.denghb.zuiyou.gateway.utils.DataUtils;
import com.denghb.zuiyou.gateway.utils.ParameterUtils;
import com.denghb.zuiyou.gateway.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
@RestController
@RequestMapping("/user/rule")
public class UserRuleController {

    Logger log = LoggerFactory.getLogger(UserRuleController.class);

    @Autowired
    private UserRuleService userRuleService;

    @RequestMapping("/listAll")
    public List<UserRuleVo> list() {
        return userRuleService.listAll();
    }


    @RequestMapping("/create")
    public JsonModel create(HttpServletRequest request, @ModelAttribute Rule rule) {
        JsonModel json = new JsonModel();
        Credential currentUser = WebUtils.getCredential(request);
        userRuleService.create(currentUser, rule);
        json.setCode(1);
        json.setMsg("执行成功");
        return json;
    }

    @RequestMapping("/update")
    public JsonModel update(HttpServletRequest request, @ModelAttribute Rule rule) {
        JsonModel json = new JsonModel();
        Credential currentUser = WebUtils.getCredential(request);
        userRuleService.update(currentUser, rule);
        json.setCode(1);
        json.setMsg("执行成功");
        return json;
    }

    @RequestMapping("/delete")
    public JsonModel delete(HttpServletRequest request, Long id) {
        Credential currentUser = WebUtils.getCredential(request);
        userRuleService.delete(currentUser, id);
        return JsonModel.buildSuccess("执行成功");
    }

    @RequestMapping("/query")
    public JsonModel query(HttpServletRequest request, Long id) {
        Credential currentUser = WebUtils.getCredential(request);
        UserRuleVo vo = userRuleService.query(currentUser, id);
        return JsonModel.buildSuccess(vo);
    }


    @RequestMapping("/list")
    public JsonModel list(HttpServletRequest request) {
        try {
            RuleCriteria criteria = new RuleCriteria();
            ParameterUtils.initDataTablesParams(request, criteria);

            Credential credential = WebUtils.getCredential(request);

            PagingResult<Rule> result = userRuleService.list(credential, criteria);
            DataTablesResult<Rule> data = DataUtils.pagingResult2DataTablesResult(result);
            return JsonModel.buildSuccess(data);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonModel.buildFailure("查询失败");
        }

    }
}
