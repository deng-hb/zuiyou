package com.denghb.zuiyou.utils;

import com.denghb.dbhelper.paging.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


/**
 * 参数处理工具
 *
 * @author denghb
 */
public class ParameterUtils {

    private final static Logger log = LoggerFactory.getLogger(ParameterUtils.class);

    /**
     * 初始化table参数
     *
     * @param request
     * @param paging
     */
    public static void initDataTablesParams(HttpServletRequest request, Paging paging) {

        try {

            String search = request.getParameter("search");
            String start = request.getParameter("start");
            String length = request.getParameter("length");
            String draw = request.getParameter("draw");

            String column = request.getParameter("column");
            String sort = request.getParameter("sort");
            // FIXME
            long startIndex = Long.parseLong(start);
            long len = Long.parseLong(length);
            if (startIndex >= len) {// 多于1页
                if (startIndex % len == 0) {
                    paging.setPage(startIndex / len + 1);
                } else {
                    paging.setPage(startIndex / len);
                }
            }
            paging.setSortIndex(Integer.parseInt(column));
            paging.setRows(len);
            paging.setDesc("desc".equals(sort));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
