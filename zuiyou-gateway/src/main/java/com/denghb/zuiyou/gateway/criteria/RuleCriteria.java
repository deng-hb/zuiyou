package com.denghb.zuiyou.gateway.criteria;

import com.denghb.dbhelper.paging.Paging;

/**
 * Created by denghb on 2017/4/25.
 */
public class RuleCriteria extends Paging {
    @Override
    public String[] getSorts() {
        return new String[]{"id"};
    }
}
