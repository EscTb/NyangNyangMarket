package com.esctb.restapiserver.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ParameterLogAop {
    @Pointcut("execution(* com.esctb.restapiserver.domain.*.controller.*.*(..))")
    public void cut(){}

    @Before("cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        log.info("method_name: {}",method.getName());
        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            log.info("type : {}",obj.getClass().getSimpleName());
            log.info("value : {}",obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        log.info("============return obj==================");
        log.info("{}",returnObj);
    }

}
