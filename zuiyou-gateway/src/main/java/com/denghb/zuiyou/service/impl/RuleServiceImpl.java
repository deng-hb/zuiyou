package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private DbHelper db;

    @Override
    public List<RuleVo> list() {
        String sql = "select r.*,ura.auth as auth,ura.user_id as userId from rule r left join user_rule_auth ura on r.id = ura.rule_id where ura.is_open = 1 and ura.deleted = 0";
        return db.list(sql, RuleVo.class);
    }
}
