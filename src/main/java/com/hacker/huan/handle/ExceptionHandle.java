package com.hacker.huan.handle;

import com.hacker.huan.entity.Result;
import com.hacker.huan.enumeration.ResultEnum;
import com.hacker.huan.exception.UserException;
import com.hacker.huan.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**捕获异常的类
 * @author wqh
 * @date 18-5-6
 */

@ControllerAdvice
public class ExceptionHandle {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e){
        if (e instanceof UserException){
            UserException userException = (UserException)e;
            return ResultUtil.fail(ResultEnum.ERROR_CODE.getErrorCode(),userException.getMessage());
        }

        return ResultUtil.success();
    }
}
