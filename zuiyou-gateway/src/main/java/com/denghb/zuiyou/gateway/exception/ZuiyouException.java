package com.denghb.zuiyou.gateway.exception;

/**
 * Created by denghb on 2017/2/6.
 */
public class ZuiyouException extends Exception {

    public ZuiyouException() {
        super();
    }

    public ZuiyouException(String message) {
        super(message);
    }

    public ZuiyouException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZuiyouException(Throwable cause) {
        super(cause);
    }

}
