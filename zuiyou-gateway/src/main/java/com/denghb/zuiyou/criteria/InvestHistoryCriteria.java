package com.denghb.zuiyou.criteria;

import com.denghb.dbhelper.paging.Paging;

/**
 * Created by denghb on 2017/4/20.
 */
public class InvestHistoryCriteria extends Paging {
    @Override
    public String[] getSorts() {
        return new String[]{"id"};
    }
}
