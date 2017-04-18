package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
