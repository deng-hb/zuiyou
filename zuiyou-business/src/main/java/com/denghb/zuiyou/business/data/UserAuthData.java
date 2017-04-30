package com.denghb.zuiyou.business.data;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.common.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by denghb on 2017/4/30.
 */
public class UserAuthData {
    private static Logger log = LoggerFactory.getLogger(UserAuthData.class);


    public static void save() {
        log.info("UserAuthData save");
        //

        String json = HttpUtils.get(Constants.Server.RULE_LIST_ALL_URL);
    }
}
