package com.denghb.zuiyou.controller;

import com.denghb.zuiyou.model.CurrentUser;
import com.denghb.zuiyou.model.JsonModel;
import com.denghb.zuiyou.service.UserRuleAuthService;
import com.denghb.zuiyou.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            String c = request.getParameter("c");
            CurrentUser currentUser = WebUtils.getCurrentUser(request);
            String pdu = getPdu(c);
            userRuleAuthService.bind(currentUser, pdu, c);
            json.setCode(1);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            json.setCode(0);
        }
        return json;
    }

    private String getPdu(String c) {
        Pattern pattern = Pattern.compile("ppd_uname=(\\S*);");
        Matcher matcher = pattern.matcher(c);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
