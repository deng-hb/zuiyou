package com.denghb.zuiyou.gateway.model;

/**
 * Created by denghb on 2017/2/6.
 */
public class JsonModel {

    private String msg;

    private Object data;

    // 0:失败,1:成功
    private int code;

    public JsonModel() {

    }

    public JsonModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonModel(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功并返回消息
     *
     * @param msg
     * @return JsonModel
     */
    public static JsonModel buildSuccess(String msg) {
        return new JsonModel(1, msg);
    }

    /**
     * 成功并返回数据
     *
     * @param data
     * @return
     */
    public static JsonModel buildSuccess(Object data) {
        return new JsonModel(1, "ok", data);
    }

    /**
     * 失败并返回消息
     *
     * @param msg
     * @return JsonModel
     */
    public static JsonModel buildFailure(String msg) {
        return new JsonModel(0, msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}
