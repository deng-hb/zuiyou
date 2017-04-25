package com.denghb.zuiyou.data;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.domain.vo.UserRuleVo;
import com.denghb.zuiyou.utils.HttpUtils;
import com.denghb.zuiyou.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
public class UserRuleVoData {

    private static Logger log = LoggerFactory.getLogger(UserRuleVoData.class);


    private static List<UserRuleVo> list = new ArrayList<>();

    public static List<UserRuleVo> getList() {
        // 第一次获取
        if (list.isEmpty()) {
            UserRuleVoData.pull();
        }
        return list;
    }

    /**
     * 更新数据
     */
    public static void pull() {
        log.info("UserRuleVoData pull");
        //
        String json = HttpUtils.get(Constants.Server.RULE_LIST_ALL_URL);
        list = JacksonUtils.toList(json, UserRuleVo.class);
    }
}
