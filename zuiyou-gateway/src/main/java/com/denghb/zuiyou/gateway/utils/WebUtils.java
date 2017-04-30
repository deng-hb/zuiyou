package com.denghb.zuiyou.gateway.utils;


import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.gateway.model.Credential;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denghb on 2017/4/11.
 */
public class WebUtils {

    /**
     * 获取当前登陆用户
     *
     * @param request
     * @return
     */
    public static Credential getCredential(HttpServletRequest request) {
        Object object = request.getSession().getAttribute(Constants.Web.CREDENTIAL);
        if (null != object && object instanceof Credential) {
            return (Credential) object;
        }
        return null;
    }


    /**
     * 获取client IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
