package com.denghb.zuiyou.gateway.exception;

import com.denghb.zuiyou.gateway.model.JsonModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonModel errorHandler(HttpServletRequest req, Exception e) {
        return JsonModel.buildFailure(e.getMessage());
    }

    @ExceptionHandler(value = ZuiyouException.class)
    @ResponseBody
    public JsonModel zuiyouErrorHandler(HttpServletRequest req, ZuiyouException e) {
        return JsonModel.buildFailure(e.getMessage());
    }
}