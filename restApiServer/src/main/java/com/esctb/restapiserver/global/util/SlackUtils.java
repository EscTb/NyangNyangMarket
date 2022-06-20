package com.esctb.restapiserver.global.util;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class SlackUtils {
    @Value("${webhook.url}")
    private String url;

    public void SendError(String message){
        RestTemplate restTemplate = new RestTemplate();

        Map<String,Object> request = new HashMap<String,Object>();
        request.put("username", "slackbot");
        request.put("text", message);

        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
