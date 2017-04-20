package com.denghb.zuiyou.service;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.criteria.InvestHistoryCriteria;
import com.denghb.zuiyou.domain.InvestHistory;
import com.denghb.zuiyou.model.CurrentUser;

/**
 * Created by denghb on 2017/4/17.
 */
public interface InvestHistoryService {

    /**
     * 创建
     *
     * @param investHistory
     */
    void create(InvestHistory investHistory);

    /**
     * 分页列表
     *
     * @param currentUser
     * @param criteria
     * @return
     */
    PagingResult<InvestHistory> list(CurrentUser currentUser, InvestHistoryCriteria criteria);
}
