package com.hacker.huan.enumeration;

/**
 * @author wqh
 * @date 18-5-6
 */
public enum ResultEnum {
    /**
     *状态码
     */
    UNKNOWN_ERROR("未知错误",-1),
    SUCCESS("成功",0),
    TOO_YOUNG("你还小就别玩了",100),
    READ_BOOK("未成年人还是读书吧",101),
    ERROR_CODE("错误码是一",1),
    ;
    private String message;
    private Integer errorCode;

    ResultEnum(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
