package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.UserRuleAuthService;
import com.denghb.zuiyou.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denghb on 2017/4/11.
 */
@RestController
@RequestMapping("/user/auth")
public class UserAuthController {

    Logger log = LoggerFactory.getLogger(UserAuthController.class);

    @Autowired
    private UserRuleAuthService userRuleAuthService;

    /**
     * 用户绑定
     *
     * @param request
     */
    @RequestMapping("/bind")
    public JsonModel bind(HttpServletRequest request) {
        JsonModel json = new JsonModel();
        try {
            String pdu  = request.getParameter("pdu");
            String token = request.getParameter("token");
            CurrentUser currentUser = WebUtils.getCurrentUser(request);
            userRuleAuthService.bind(currentUser, pdu, token);
            json.setCode(1);
            json.setMsg("绑定成功");
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            json.setCode(0);
            json.setMsg("绑定失败");
        }
        return json;
    }

}
