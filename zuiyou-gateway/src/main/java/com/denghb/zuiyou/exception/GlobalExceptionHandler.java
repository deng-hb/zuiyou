package com.denghb.zuiyou.exception;

import com.denghb.zuiyou.model.JsonModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonModel errorHandler(HttpServletRequest req, Exception e) {
        JsonModel json = new JsonModel();
        json.setMsg(e.getMessage());
        json.setCode(0);
        return json;
    }

    @ExceptionHandler(value = ZuiyouException.class)
    @ResponseBody
    public JsonModel jsonErrorHandler(HttpServletRequest req, ZuiyouException e) {
        JsonModel json = new JsonModel();
        json.setMsg(e.getMessage());
        json.setCode(0);
        return json;
    }
}