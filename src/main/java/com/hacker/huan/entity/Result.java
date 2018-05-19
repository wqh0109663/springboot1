package com.hacker.huan.entity;

import java.util.HashMap;

/**
 * http返回格式
 *
 * @author wqh
 * @date 18-5-6
 */
public class Result<T> {
    /**
     * 错误状态码
     */
    private Integer errorCode;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 具体内容
     */
    private T data;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
