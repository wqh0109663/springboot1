package com.hacker.huan.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wqh
 * @date 18-5-6
 */
@Component
@Aspect
public class UserAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAspect.class);
    @Pointcut("execution(public * com.hacker.huan.controller.UserController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void isInvalid(){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.info("url={}",request.getRequestURL());
        LOGGER.info("ip={}",request.getRemoteAddr());
    }
    @After("log()")
    public void testAfter(){
        LOGGER.info("方法结束了");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object){
        LOGGER.info(object.toString());
    }
}
