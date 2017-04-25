package com.denghb.zuiyou.service;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.criteria.HistoryCriteria;
import com.denghb.zuiyou.domain.History;
import com.denghb.zuiyou.model.Credential;

/**
 * Created by denghb on 2017/4/17.
 */
public interface HistoryService {

    /**
     * 创建
     *
     * @param history
     */
    void create(History history);

    /**
     * 分页列表
     *
     * @param credential
     * @param criteria
     */
    PagingResult<History> list(Credential credential, HistoryCriteria criteria);
}
