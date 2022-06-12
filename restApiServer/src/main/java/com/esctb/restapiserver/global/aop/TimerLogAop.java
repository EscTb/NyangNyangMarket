package com.esctb.restapiserver.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class TimerLogAop {
    @Pointcut("execution(* com.esctb.restapiserver.domain.*.controller.*.*(..))")
    public void cut(){}

    @Pointcut("@annotation(com.esctb.restapiserver.global.annotation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        log.info("total time : {}",stopWatch.getTotalTimeSeconds());

        return result;
    }
}
