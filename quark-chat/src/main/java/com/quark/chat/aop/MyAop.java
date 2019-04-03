package com.quark.chat.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {

    private static final Logger log = LoggerFactory.getLogger(MyAop.class);

    @Pointcut("execution(* com.quark.chat.service.impl.*.*(..))")
    public void controllserAspect(){

    }

    @After("controllserAspect()")
    public void after(JoinPoint joinPoint){
        //包名
        String targetName = joinPoint.getTarget().getClass().getName();
        //方法名
        String methodName = joinPoint.getSignature().getName();

        log.info("执行了chat--service--",targetName+"---"+methodName);


    }

}
