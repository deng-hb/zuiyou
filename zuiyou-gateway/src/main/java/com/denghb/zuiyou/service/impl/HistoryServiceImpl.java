package com.denghb.zuiyou.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.dbhelper.utils.DbHelperUtils;
import com.denghb.zuiyou.criteria.HistoryCriteria;
import com.denghb.zuiyou.domain.History;
import com.denghb.zuiyou.model.Credential;
import com.denghb.zuiyou.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by denghb on 2017/4/17.
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private DbHelper db;

    @Override
    public void create(History history) {
        db.insert(history);
    }

    @Override
    public PagingResult<History> list(Credential credential, HistoryCriteria criteria) {

        StringBuffer sql = new StringBuffer();
        sql.append(DbHelperUtils.getSelectSql(History.class));

        return db.list(sql, History.class, criteria);
    }
}
