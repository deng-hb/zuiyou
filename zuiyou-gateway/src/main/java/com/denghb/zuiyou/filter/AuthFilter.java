package com.denghb.zuiyou.filter;

import com.denghb.zuiyou.constant.Constants;
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
import java.util.Arrays;
import java.util.List;

/**
 * Created by denghb on 2017/4/11.
 */
public class AuthFilter implements Filter {
    private final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    private List<String> exclusionList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusions = filterConfig.getInitParameter(Constants.Web.KEY_EXCLUSIONS);
        String strs[] = exclusions.split(",");
        exclusionList = Arrays.asList(strs);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        // 请求路径
        String uri = request.getRequestURI();
        CurrentUser currentUser = WebUtils.getCurrentUser(request);
        log.info("uri:{},current:{}", uri, null == currentUser ? "nil" : "exist");

        // 未登录、而且不是可访问地址
        if (!exclusionList.contains(uri) && null == currentUser) {
            request.getSession().invalidate();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");

            JsonModel model = new JsonModel();
            model.setCode(2);
            model.setMsg("未授权");
            String json = JacksonUtils.toJson(model);

            response.getWriter().write(json);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
