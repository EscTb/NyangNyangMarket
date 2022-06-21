package com.esctb.restapiserver.global.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class RequestLogAop {

    private final ObjectMapper objectMapper;

    @Pointcut("execution(* com.esctb.restapiserver.domain.*.controller.*.*(..))")
    public void cut(){}

    @Around("cut()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        final ContentCachingRequestWrapper cachingRequestWrapper=(ContentCachingRequestWrapper) request;

        Object value;

        try{
            value=proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            throw throwable;
        }finally {
            log.info("===============================API Reqeust===============================");
            log.info("Request Time: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss")));
            log.info("Method: {}",request.getMethod());
            log.info("URL: {}",request.getRequestURL());
            log.info("URI: {}",request.getRequestURI());
            log.info("QueryString: {}",request.getQueryString()==null?"":request.getQueryString());
            log.info("Request Body: {}",objectMapper.readTree(cachingRequestWrapper.getContentAsByteArray()));
        }
        return value;
    }
}
