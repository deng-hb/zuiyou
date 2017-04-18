package com.denghb.zuiyou.data;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.domain.vo.RuleVo;
import com.denghb.zuiyou.utils.HttpUtils;
import com.denghb.zuiyou.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denghb on 2017/4/17.
 */
public class RuleVoData {

    private static Logger log = LoggerFactory.getLogger(RuleVoData.class);


    private static List<RuleVo> list = new ArrayList<>();

    public static List<RuleVo> getList() {
        // 第一次获取
        if (list.isEmpty()) {
            RuleVoData.pull();
        }
        return list;
    }

    /**
     * 更新数据
     */
    public static void pull() {
        log.info("RuleVoData pull");
        //
        String json = HttpUtils.get(Constants.Server.RULE_LIST_URL);
        list = JacksonUtils.toList(json, RuleVo.class);
    }
}
