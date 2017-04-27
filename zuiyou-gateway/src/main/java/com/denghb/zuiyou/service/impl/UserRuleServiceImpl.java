package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.dbhelper.utils.DbHelperUtils;
import com.denghb.zuiyou.criteria.RuleCriteria;
import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.UserRule;
import com.denghb.zuiyou.domain.vo.UserRuleVo;
import com.denghb.zuiyou.model.Credential;
import com.denghb.zuiyou.service.UserRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
@Service
public class UserRuleServiceImpl implements UserRuleService {

    @Autowired
    private DbHelper db;

    @Override
    public List<UserRuleVo> listAll() {
        String sql = "select r.*,ua.token as token,ur.user_id as userId from user_rule ur left join rule r on r.id = ur.rule_id " +
                " left join user_auth ua on ua.user_id = ur.user_id and ua.pdu = ur.pdu where ur.deleted = 0 and ua.deleted = 0 and ua.is_open = 1 ";
        return db.list(sql, UserRuleVo.class);
    }

    @Override
    public void create(Credential credential, String pdu, Rule rule) {
        db.insert(rule);


        // 绑定
        UserRule ur = new UserRule();
        ur.setRuleId(rule.getId());
        ur.setUserId(credential.getUserId());
        ur.setPdu(pdu);
        db.insert(ur);
    }

    @Transactional
    @Override
    public void update(Credential credential, Rule rule) {

        // 更新
        db.updateById(rule);

    }

    @Override
    public void delete(Credential credential, long id) {
        UserRule ur = db.queryForObject("select * from user_rule where user_id = ? and rule_id = ? and deleted = 0", UserRule.class, credential.getUserId(), id);
        ur.setDeleted(true);
        db.updateById(ur);

        Rule rule = new Rule();
        rule.setId(id);
        rule.setDeleted(true);
        db.updateById(rule);
    }

    @Override
    public PagingResult<Rule> list(Credential credential, RuleCriteria criteria) {
        StringBuffer sql = new StringBuffer();
        sql.append(DbHelperUtils.getSelectSql(Rule.class));

        return db.list(sql, Rule.class, criteria);
    }

}
