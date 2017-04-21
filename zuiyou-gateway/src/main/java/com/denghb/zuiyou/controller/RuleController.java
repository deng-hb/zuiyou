package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.RuleService;
import com.denghb.zuiyou.utils.WebUtils;
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
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping("/list")
    public List<RuleVo> list() {
        return ruleService.list();
    }


    @RequestMapping("/save")
    public JsonModel save(HttpServletRequest request, @ModelAttribute("rule") Rule rule) {
        JsonModel json = new JsonModel();
        CurrentUser currentUser = WebUtils.getCurrentUser(request);
        ruleService.save(currentUser, rule);
        json.setCode(1);
        json.setMsg("执行成功");
        return json;
    }
}
