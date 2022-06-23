package com.esctb.restapiserver.global.util;

import com.esctb.restapiserver.global.error.ErrorCode;
import com.esctb.restapiserver.global.error.ErrorResponse;
import com.esctb.restapiserver.global.error.exception.CustomException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SlackUtils {
    @Value("${webhook.url}")
    private String url;

    private final ObjectMapper objectMapper;

    public void SendError(ErrorCode errorCode, HttpServletRequest request) throws IOException {
        final ContentCachingRequestWrapper cachingRequestWrapper=(ContentCachingRequestWrapper) request;
        RestTemplate restTemplate = new RestTemplate();

        String text = "Request Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss")) + "\n" +
                "Method: " + request.getMethod() + "\n" +
                "URL: " + request.getRequestURL() + "\n";

        SlackMessageDetail errorInfo=SlackMessageDetail.builder()
                .title("ERROR INFO")
                .value(
                        "Request Time: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss"))+"\n"+
                        "Status Code: "+errorCode.getHttpStatus().value()+"\n"+
                        "Error Name: "+errorCode.getHttpStatus().name()+"\n"+
                        "Error Code: "+errorCode.name()+"\n"+
                        "Error Detail: "+errorCode.getDetail()+"\n"
                )
                .build();

        SlackMessageDetail requestBody=SlackMessageDetail.builder()
                .title("REQUEST BODY")
                .value(objectMapper.readTree(cachingRequestWrapper.getContentAsByteArray()).asText())
                .build();

        List<SlackMessageDetail> list= new ArrayList<>();
        list.add(errorInfo);
        list.add(requestBody);

        SlackMessage slackMessage=SlackMessage.builder()
                .pretext("⚠️요청이 실패했습니다.")
                .color("#FF0000")
                .title("REQUEST INFO")
                .text(text)
                .fields(list)
                .build();

        List<SlackMessage>attachments=new ArrayList<>();
        attachments.add(slackMessage);

        Map<String,Object> slackRequest = new HashMap<String,Object>();
        slackRequest.put("username", "에러 알리미");
        slackRequest.put("attachments", attachments);

        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(slackRequest);

        System.out.println(objectMapper.writeValueAsString(attachments));

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
