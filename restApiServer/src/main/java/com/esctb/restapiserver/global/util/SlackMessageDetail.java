package com.esctb.restapiserver.global.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Component
public class SlackMessageDetail {
    private String title;
    private String value;
//    @JsonProperty("short")
//    private Boolean shorts;
}
