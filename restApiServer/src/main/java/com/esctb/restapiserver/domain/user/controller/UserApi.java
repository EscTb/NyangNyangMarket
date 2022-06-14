package com.esctb.restapiserver.domain.user.controller;

import com.esctb.restapiserver.domain.user.dto.LoginDto;
import com.esctb.restapiserver.domain.user.dto.UserDto;
import com.esctb.restapiserver.domain.user.dto.joinUserRequestDto;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.service.UserService;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    //회원가입
    @PostMapping("/join")
    public Long join(@RequestBody joinUserRequestDto requestUserDto){
        return userService.join(requestUserDto);
    }

    //로그인
    @PostMapping("/login")
    public ApiResponse<UserDto> login(@RequestBody LoginDto loginDto){
        UserDto response = userService.getMemberLoginCheck(loginDto);
        return ApiResponse.createSuccess(response);
    }
}
