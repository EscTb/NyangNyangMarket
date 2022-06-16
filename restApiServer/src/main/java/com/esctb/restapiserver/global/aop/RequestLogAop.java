package com.esctb.restapiserver.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class RequestLogAop {

    @Pointcut("execution(* com.esctb.restapiserver.domain.*.controller.*.*(..))")
    public void cut(){}

    @Around("cut()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        Object value;

        try{
            value=proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            throw throwable;
        }finally {
            log.info(
                    "/ᐠ｡ꞈ｡ᐟ✿\\ {} {} from {} /ᐠ｡‸｡ᐟ\\",
                    request.getMethod(),
                    request.getRequestURI(),
                    request.getRemoteAddr());
        }
        return value;
    }
}
