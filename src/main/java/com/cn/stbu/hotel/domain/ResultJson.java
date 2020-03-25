package com.cn.stbu.hotel.domain;

/**
 * Description: 结果值返回类
 * Datetime:    2020/2/29 0029   22:31
 * Author:  IDEA
 */
public class ResultJson<T> {
    private int code;   //状态码
    private String msg; //消息
    private T data;     //数据

    public ResultJson(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
