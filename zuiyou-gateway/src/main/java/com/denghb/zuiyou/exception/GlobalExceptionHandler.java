package com.denghb.zuiyou.exception;

import com.denghb.zuiyou.model.JsonModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public JsonModel jsonErrorHandler(HttpServletRequest req, JsonException e) throws Exception {
        JsonModel json = new JsonModel();
        json.setMsg(e.getMessage());
        json.setCode(-1);
        return json;
    }
}