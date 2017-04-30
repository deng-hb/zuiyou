package com.denghb.zuiyou.gateway.criteria;

import com.denghb.dbhelper.paging.Paging;

/**
 * Created by denghb on 2017/4/30.
 */
public class UserAuthCriteria extends Paging {
    @Override
    public String[] getSorts() {
        return new String[]{"id"};
    }
}
