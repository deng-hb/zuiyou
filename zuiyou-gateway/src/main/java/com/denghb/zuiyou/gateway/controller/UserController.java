package com.denghb.zuiyou.gateway.controller;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.domain.User;
import com.denghb.zuiyou.gateway.model.Credential;
import com.denghb.zuiyou.gateway.model.JsonModel;
import com.denghb.zuiyou.gateway.utils.WebUtils;
import com.denghb.zuiyou.gateway.service.UserService;
import com.denghb.zuiyou.gateway.other.GeetestLib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by denghb on 2017/4/11.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // 登录
    @RequestMapping(value = "/signin")
    public JsonModel signin(HttpServletRequest request) {


        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);

        String username = request.getParameter("username");
        if (!StringUtils.hasText(username)) {
            return JsonModel.buildFailure("账号不能为空");
        }
        String password = request.getParameter("password");
        if (!StringUtils.hasText(password)) {
            return JsonModel.buildFailure("密码不能为空");
        }

        GeetestLib gtSdk = new GeetestLib();

        int gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode);
        if (1 != gtResult) {
            log.error("sign in error:滑动验证失败");
            //return JsonModel.buildFailure("滑动验证失败");
        }

        // TODO 登陆记录
        String userAgent = request.getHeader("User-Agent");
        String ipAddr = WebUtils.getIpAddr(request);

        User user = userService.signin(username, password);
        if (null == user) {
            log.warn("sign error username{},ipAddr:{}\n,userAgent:{}", username, userAgent, ipAddr);
            return JsonModel.buildFailure("登陆失败，用户不存在或密码错误");
        }


        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setUserId(user.getId());

        // 用户信息保存至新的session里面
        HttpSession session = request.getSession();
        session.setAttribute(Constants.Web.CREDENTIAL, credential);

        return JsonModel.buildSuccess("登录成功！");
    }

    @RequestMapping(value = "/signup")
    public JsonModel signup(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        if (!StringUtils.hasText(email)) {
            return JsonModel.buildFailure("账号不能为空");
        }
        String password = request.getParameter("password");
        if (!StringUtils.hasText(password)) {
            return JsonModel.buildFailure("密码不能为空");
        }

        try {
            User user = userService.signup(email, password);
            Credential credential = new Credential();
            credential.setUsername(email);
            credential.setUserId(user.getId());

            // 用户信息保存至新的session里面
            HttpSession session = request.getSession();
            session.setAttribute(Constants.Web.CREDENTIAL, credential);

            return JsonModel.buildSuccess("注册成功！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonModel.buildFailure("注册失败，请稍后重试！");

        }
    }

    @RequestMapping(value = "/signout")
    public JsonModel signout(HttpServletRequest request) {
        request.getSession().invalidate();
        return JsonModel.buildSuccess("退出成功！");
    }
}
