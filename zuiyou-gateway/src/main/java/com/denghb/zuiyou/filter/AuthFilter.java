package com.denghb.zuiyou.filter;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.utils.JacksonUtils;
import com.denghb.zuiyou.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denghb on 2017/4/11.
 */
public class AuthFilter implements Filter {
    private final Logger log = LoggerFactory.getLogger(AuthFilter.class);


    private List<String> exclusions = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO 可以写在配置文件
        exclusions.add("/");
        exclusions.add("/favicon.ico");
        exclusions.add("/pdu/receive");
        exclusions.add("/loan/receive");
        exclusions.add("/user/signin");
        exclusions.add("/user/signup");
        exclusions.add("/rule/list");
        exclusions.add("/invest/history/create");
        exclusions.add("/cmd");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String method = request.getMethod();
        // 所有请求必须加
        String client = request.getHeader("X-Client");
        // 请求路径
        String uri = request.getRequestURI();
        CurrentUser currentUser = WebUtils.getCurrentUser(request);
        String ipAddr = WebUtils.getIpAddr(request);
        log.info("client:[{}],method:[{}],ip,[{}],uri:[{}],current:[{}]", client, method, ipAddr, uri, null == currentUser ? "nil" : currentUser.getUsername());

        if (null == client || 0 != client.indexOf("don't touch me")) {
            error(request, response);
            return;
        }
        // 未登录、而且不是可访问地址
        if (!exclusions.contains(uri) && null == currentUser) {
            error(request, response);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void error(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession().invalidate();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        JsonModel model = new JsonModel();
        model.setCode(2);
        model.setMsg("未登录或会话超时，请重新登录！");
        model.setData("https://" + Constants.Server.HOST);// 网站首页
        String json = JacksonUtils.toJson(model);

        response.getWriter().write(json);
    }

}
