package com.hacker.huan.exception;

import com.hacker.huan.enumeration.ResultEnum;

/**
 * @author wqh
 * @date 18-5-6
 */
public class UserException  extends  RuntimeException{
    private Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public UserException(String s, Integer errorCode) {
        super(s);
        this.errorCode = errorCode;
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.errorCode = resultEnum.getErrorCode();
    }
}
