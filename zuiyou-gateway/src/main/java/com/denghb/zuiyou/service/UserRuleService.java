package com.denghb.zuiyou.service;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.criteria.RuleCriteria;
import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.vo.UserRuleVo;
import com.denghb.zuiyou.model.Credential;

import java.util.List;

/**
 * Created by denghb on 2017/4/25.
 */
public interface UserRuleService {

    /**
     * 所有有效的规则
     *
     * @return
     */
    List<UserRuleVo> listAll();

    /**
     * 创建规则
     *
     * @param credential
     * @param rule
     */
    void create(Credential credential, Rule rule);

    /**
     * 修改规则
     *
     * @param credential
     * @param rule
     */
    void update(Credential credential, Rule rule);

    /**
     * 删除
     *
     * @param credential
     * @param id
     */
    void delete(Credential credential, long id);


    /**
     * 绑定pdu
     *
     * @param credential
     * @param id
     * @param pdu
     */
    void bind(Credential credential, long id, String pdu);

    /**
     * 查询
     *
     * @param credential
     * @param criteria
     * @return PagingResult<Rule>
     */
    PagingResult<Rule> list(Credential credential, RuleCriteria criteria);
}
