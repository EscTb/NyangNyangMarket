package com.esctb.restapiserver.global.error;

import com.esctb.restapiserver.global.error.exception.CustomException;
import com.esctb.restapiserver.global.util.SlackUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.esctb.restapiserver.global.error.ErrorCode.DUPLICATE_RESOURCE;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final SlackUtils slackUtils;
    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = { ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> handleDataException() {
        log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
        return ErrorResponse.toResponseEntity(DUPLICATE_RESOURCE);
    }

    @ExceptionHandler(value = { CustomException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e, HttpServletRequest request) throws IOException {
        final ContentCachingRequestWrapper cachingRequestWrapper=(ContentCachingRequestWrapper) request;
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());

        StringBuilder sb=new StringBuilder();
        sb.append("===============================API REQUEST ERROR===============================\n")
          .append("Request Time: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss"))).append("\n")
          .append("Method: ").append(request.getMethod()).append("\n")
          .append("URL: ").append(request.getRequestURL()).append("\n")
          .append("URI: ").append(request.getRequestURI()).append("\n")
          .append("QueryString: ").append(request.getQueryString()==null?"":request.getQueryString()).append("\n")
          .append("Request Body: ").append(objectMapper.readTree(cachingRequestWrapper.getContentAsByteArray())).append("\n");

        log.error(sb.toString());

        slackUtils.SendError(e.getErrorCode(),request);

        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}