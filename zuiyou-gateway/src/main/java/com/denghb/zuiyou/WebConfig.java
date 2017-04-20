package com.denghb.zuiyou;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by denghb on 2017/4/11.
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean authFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        // filterRegistrationBean.addInitParameter(Constants.Web.KEY_EXCLUSIONS, "/,/favicon.ico,/user/signin");
        return filterRegistrationBean;
    }


}
