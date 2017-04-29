package com.denghb.zuiyou.openapi.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by denghb on 2017/4/30.
 */
public class LoanUtils {

    private static Map<Integer, Boolean> data = new ConcurrentHashMap<Integer, Boolean>();


    public static List<Integer> getNewIds() {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer id : data.keySet()) {
            Boolean b = data.get(id);
            if (!b) {
                list.add(id);
            }
        }
        return list;
    }

    public static void useIds(List<Integer> ids) {
        for (Integer id : ids) {
            // 将未使用的改成使用
            if (false == data.get(id)) {
                data.put(id, true);
            }
        }
    }

    public static void setId(Integer id) {

        // 不存在才添加
        if (null == data.get(id)) {
            data.put(id, false);
        }
    }
}
