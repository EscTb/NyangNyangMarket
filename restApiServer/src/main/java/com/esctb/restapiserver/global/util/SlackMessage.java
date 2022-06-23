package com.esctb.restapiserver.global.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class SlackMessage {
    private String pretext;
    private String color;
    private String title;
    private String text;
    private List<SlackMessageDetail> fields;
}
