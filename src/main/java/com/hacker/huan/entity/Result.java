package com.hacker.huan.entity;


import lombok.Data;
import lombok.ToString;

/**
 * http返回格式
 *
 * @author wqh
 * @date 18-5-6
 */
@Data
@ToString
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

}
