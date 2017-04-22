package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.domain.Rule;
import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.domain.vo.UserRuleAuthVo;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.service.RuleService;
import com.denghb.zuiyou.service.UserRuleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private DbHelper db;

    @Autowired
    private UserRuleAuthService userRuleAuthService;

    @Override
    public List<RuleVo> list() {
        String sql = "select r.*,ura.token as token,ura.user_id as userId,ura.pdu as pdu from rule r left join user_rule_auth ura on r.id = ura.rule_id where ura.is_open = 1 and ura.deleted = 0";
        return db.list(sql, RuleVo.class);
    }

    @Transactional
    @Override
    public void save(CurrentUser currentUser, Rule rule) {
        UserRuleAuthVo vo = userRuleAuthService.queryUserRuleAuthInfo(currentUser);

        // 更新
        rule.setId(vo.getRule().getId());
        db.updateById(rule);

        // 每次更新都关闭
        userRuleAuthService.close(currentUser);

    }

}
