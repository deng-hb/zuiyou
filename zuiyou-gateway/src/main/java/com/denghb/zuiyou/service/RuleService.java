package com.denghb.zuiyou.service;

import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.model.CurrentUser;

import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
public interface RuleService {

    /**
     * 全部
     *
     * @return
     */
    List<RuleVo> list();


    /**
     * 保存
     *
     * @param currentUser
     * @param rule
     */
    void save(CurrentUser currentUser, Rule rule);

}
