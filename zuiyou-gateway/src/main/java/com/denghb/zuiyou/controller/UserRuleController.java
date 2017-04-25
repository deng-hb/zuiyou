package com.denghb.zuiyou.controller;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.criteria.RuleCriteria;
import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.vo.UserRuleVo;
import com.denghb.zuiyou.model.Credential;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.UserRuleService;
import com.denghb.zuiyou.utils.DataUtils;
import com.denghb.zuiyou.utils.ParameterUtils;
import com.denghb.zuiyou.utils.WebUtils;
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
        JsonModel json = new JsonModel();
        Credential currentUser = WebUtils.getCredential(request);
        userRuleService.delete(currentUser, id);
        json.setCode(1);
        json.setMsg("执行成功");
        return json;
    }



    @RequestMapping("/list")
    public JsonModel list(HttpServletRequest request) {
        JsonModel json = new JsonModel();
        try {
            RuleCriteria criteria = new RuleCriteria();
            ParameterUtils.initDataTablesParams(request, criteria);

            Credential credential = WebUtils.getCredential(request);

            PagingResult<Rule> result = userRuleService.list(credential, criteria);
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
