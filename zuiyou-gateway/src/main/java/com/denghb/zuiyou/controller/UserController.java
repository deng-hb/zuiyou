package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.domain.User;
import com.denghb.zuiyou.model.Credential;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.UserService;
import com.denghb.zuiyou.utils.WebUtils;
import com.denghb.zuiyou.other.GeetestLib;
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

        JsonModel json = new JsonModel();
        json.setCode(0);

        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);

        String username = request.getParameter("username");
        if (!StringUtils.hasText(username)){
            json.setMsg("账号不能为空");
            return json;
        }
        String password = request.getParameter("password");
        if (!StringUtils.hasText(password)){
            json.setMsg("密码不能为空");
            return json;
        }

        GeetestLib gtSdk = new GeetestLib();

        int gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode);
        if (1 != gtResult) {
            log.error("sign in error:滑动验证失败");
            json.setMsg("滑动验证失败");
            return json;
        }

        // TODO 登陆记录
        String userAgent = request.getHeader("User-Agent");
        String ipAddr = WebUtils.getIpAddr(request);

        User user = userService.signin(username, password);
        if (null == user) {
            log.warn("sign error username{},ipAddr:{}\n,userAgent:{}", username, userAgent, ipAddr);
            json.setMsg("登陆失败，用户不存在或密码错误");
            return json;
        }


        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setUserId(user.getId());

        // 用户信息保存至新的session里面
        HttpSession session = request.getSession();
        session.setAttribute(Constants.Web.CREDENTIAL, credential);

        json.setCode(1);
        return json;
    }

    @RequestMapping(value = "/signup")
    public JsonModel signup(HttpServletRequest request, HttpServletResponse response) {

        JsonModel json = new JsonModel();
        json.setCode(0);

        String email = request.getParameter("email");
        if (!StringUtils.hasText(email)){
            json.setMsg("账号不能为空");
            return json;
        }
        String password = request.getParameter("password");
        if (!StringUtils.hasText(password)){
            json.setMsg("密码不能为空");
            return json;
        }

        try {
            User user = userService.signup(email, password);
            Credential credential = new Credential();
            credential.setUsername(email);
            credential.setUserId(user.getId());

            // 用户信息保存至新的session里面
            HttpSession session = request.getSession();
            session.setAttribute(Constants.Web.CREDENTIAL, credential);

            json.setCode(1);
            return json;
        } catch (Exception e){
            log.error(e.getMessage(), e);
            json.setMsg("注册失败，请稍后重试！");
            return json;
        }
    }
}
