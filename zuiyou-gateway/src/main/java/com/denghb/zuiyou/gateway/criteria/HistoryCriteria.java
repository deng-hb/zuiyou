package com.denghb.zuiyou.gateway.criteria;

import com.denghb.dbhelper.paging.Paging;

/**
 * Created by denghb on 2017/4/20.
 */
public class HistoryCriteria extends Paging {
    @Override
    public String[] getSorts() {
        return new String[]{"id"};
    }
}
