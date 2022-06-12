package com.esctb.restapiserver.domain.user.controller;

import com.esctb.restapiserver.domain.user.dto.joinUserRequestDto;
import com.esctb.restapiserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("/join")
    public Long join(@RequestBody joinUserRequestDto requestUserDto){
        return userService.join(requestUserDto);
    }
}
