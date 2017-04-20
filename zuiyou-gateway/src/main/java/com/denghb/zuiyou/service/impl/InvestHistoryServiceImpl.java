package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.dbhelper.utils.DbHelperUtils;
import com.denghb.zuiyou.criteria.InvestHistoryCriteria;
import com.denghb.zuiyou.domain.InvestHistory;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.service.InvestHistoryService;
import com.denghb.dbhelper.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by denghb on 2017/4/17.
 */
@Service
public class InvestHistoryServiceImpl implements InvestHistoryService {

    @Autowired
    private DbHelper db;

    @Override
    public void create(InvestHistory investHistory) {
        db.insert(investHistory);
    }

    @Override
    public PagingResult<InvestHistory> list(CurrentUser currentUser, InvestHistoryCriteria criteria) {

        StringBuffer sql = new StringBuffer();
        sql.append(DbHelperUtils.getSelectSql(InvestHistory.class));

        return db.list(sql, InvestHistory.class, criteria);
    }
}
