package com.denghb.zuiyou.openapi.utils;

import com.denghb.zuiyou.openapi.domain.LoanInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by denghb on 2017/4/30.
 */
public class LoanUtils {

    private static Map<Integer, Boolean> data = new ConcurrentHashMap<Integer, Boolean>();
    private static Map<Integer, LoanInfo> loanInfoMap = new ConcurrentHashMap<>();


    public static void init(List<LoanInfo> list){

        for (LoanInfo loanInfo : list){
            Integer id = loanInfo.getId();

            if (null == data.get(id)) {
                data.put(id, false);
            }

            loanInfoMap.put(id, loanInfo);
        }
    }

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

    // 将用过的移除
    public static void useIds(List<Integer> ids) {
        for (Integer id : ids) {
            // 将未使用的改成使用
            if (false == data.get(id)) {
                data.put(id, true);
                loanInfoMap.remove(id);
            }
        }
    }

    public static LoanInfo getLoanInfo(Integer id){
        return loanInfoMap.get(id);
    }
}
