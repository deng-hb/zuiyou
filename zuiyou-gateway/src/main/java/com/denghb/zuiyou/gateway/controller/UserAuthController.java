package com.denghb.zuiyou.gateway.controller;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.zuiyou.domain.UserAuth;
import com.denghb.zuiyou.gateway.criteria.UserAuthCriteria;
import com.denghb.zuiyou.gateway.model.Credential;
import com.denghb.zuiyou.gateway.model.DataTablesResult;
import com.denghb.zuiyou.gateway.model.JsonModel;
import com.denghb.zuiyou.gateway.service.UserAuthService;
import com.denghb.zuiyou.gateway.utils.DataUtils;
import com.denghb.zuiyou.gateway.utils.ParameterUtils;
import com.denghb.zuiyou.gateway.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/11.
 */
@RestController
@RequestMapping("/user/auth")
public class UserAuthController {

    private Logger log = LoggerFactory.getLogger(UserAuthController.class);

    @Autowired
    private UserAuthService userAuthService;

    /**
     * 用户绑定
     *
     * @param request
     */
    @RequestMapping("/bind")
    public JsonModel bind(HttpServletRequest request) {
        try {
            String pdu = request.getParameter("pdu");
            String token = request.getParameter("token");
            Credential credential = WebUtils.getCredential(request);
            userAuthService.bind(credential, pdu, token);
            return JsonModel.buildSuccess("绑定成功");
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return JsonModel.buildFailure("绑定失败");
        }
    }

    @RequestMapping("/open")
    public JsonModel open(HttpServletRequest request, String pdu) {

        try {
            Credential credential = WebUtils.getCredential(request);
            userAuthService.open(credential, pdu);
            return JsonModel.buildSuccess("操作成功");

        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return JsonModel.buildFailure("操作失败");

        }
    }

    @RequestMapping("/close")
    public JsonModel close(HttpServletRequest request, String pdu) {

        try {
            Credential credential = WebUtils.getCredential(request);
            userAuthService.close(credential, pdu);
            return JsonModel.buildSuccess("操作成功");
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return JsonModel.buildFailure("操作失败");
        }
    }

    // handler操作
    @RequestMapping("/updateBalance")
    public JsonModel updateBalance(String pdu, BigDecimal balance) {

        try {

            userAuthService.updateBalance(pdu, balance);
            return JsonModel.buildSuccess("操作成功");
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return JsonModel.buildFailure("操作失败");

        }
    }

    // handler操作
    @RequestMapping("/invalid")
    public JsonModel invalid(String pdu) {
        try {

            userAuthService.invalid(pdu);
            return JsonModel.buildSuccess("操作成功");
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return JsonModel.buildFailure("操作失败");
        }
    }

    @RequestMapping("/list")
    public JsonModel list(HttpServletRequest request) {
        UserAuthCriteria criteria = new UserAuthCriteria();
        ParameterUtils.initDataTablesParams(request, criteria);

        Credential credential = WebUtils.getCredential(request);
        PagingResult<UserAuth> result = userAuthService.list(credential, criteria);
        DataTablesResult<UserAuth> data = DataUtils.pagingResult2DataTablesResult(result);
        return JsonModel.buildSuccess(data);
    }

}
