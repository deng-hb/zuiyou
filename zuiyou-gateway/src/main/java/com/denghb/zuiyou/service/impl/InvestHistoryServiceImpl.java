package com.denghb.zuiyou.service.impl;

import com.denghb.zuiyou.domain.InvestHistory;
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
}
