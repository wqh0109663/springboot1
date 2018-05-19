package com.hacker.huan.utils;

import com.hacker.huan.entity.Result;
import com.hacker.huan.enumeration.ResultEnum;

/**结果工具类
 * @author wqh
 * @date 18-5-6
 */
public class ResultUtil {
    /**
     *结果为成功的方法
     * @param object object对象
     * @return result
     */
    public static Result success(Object object){
        Result<Object> objectResult = new Result<>();
        objectResult.setErrorCode(ResultEnum.SUCCESS.getErrorCode());
        objectResult.setMessage(ResultEnum.SUCCESS.getMessage());
        objectResult.setData(object);
        return objectResult;
    }

    /**
     * 结果为失败的方法
     * @param errorCode 错误码
     * @param message 错误信息
     * @return result
     */
    public static Result fail(Integer errorCode ,String message){
        Result<Object> objectResult = new Result<>();
        objectResult.setErrorCode(errorCode);
        objectResult.setMessage(message);
        return objectResult;
    }

    /**
     * 结果成功但是返回为null的方法
     * @return result空数据的对象
     */
    public static Result success(){
        return success(null);
    }
}
