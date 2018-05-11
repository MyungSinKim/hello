/*
 * 四川生学教育科技有限公司
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */
package com.example.hello.aop;

import com.example.hello.common.ResultBean;
import com.example.hello.exception.CheckException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/10 10:54
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Aspect
@Component
public class ResultBeanAOP {
    private static final Logger logger = LoggerFactory.getLogger(ResultBeanAOP.class);

    /**
     * execution(* com.example.hello.controller..*.*(..))
     * 解释如下：符号 含义
     * execution（），表达式的主体；
     * 第一个”*“符号，表示返回值的类型任意；
     * com.example.hello.controller    AOP所切的服务的包名，即，我们的Controller部分
     * 包名后面的”..“  表示当前包及子包
     * 第二个”*“ 表示类名，*即所有类。此处可以自定义，下文有举例
     * .*(..) 表示任何方法名，括号表示参数，两个点表示任何参数类型
     * execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)  除了返回类型模式、方法名模式和参数模式外，其它项都是可选的。
     */
    @Pointcut("execution(com.example.hello.common.ResultBean com.example.hello.controller..*.*(..))")
    public void resultBeanPointcut() {
    }

    @Before("resultBeanPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        /*
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        */
    }

    @AfterReturning("resultBeanPointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
    }

    @Around("resultBeanPointcut()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pjp.proceed();
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }

    public ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();
        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        } else {
            logger.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);
            //未知异常重点处理，可以发邮件等
        }
        return result;
    }
}
