package com.denghb.zuiyou.exception;

/**
 * Created by denghb on 2017/2/6.
 */
public class JsonException extends Exception {

    public JsonException() {
        super();
    }

    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }

}
