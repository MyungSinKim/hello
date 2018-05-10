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
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/10 10:54
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Aspect
@Configuration
public class ControllerAOP {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    @Pointcut("execution(public com.example.hello.common.ResultBean *(..))")
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
