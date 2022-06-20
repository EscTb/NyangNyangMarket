package com.esctb.restapiserver.domain.user.controller;

import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.service.UserService;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.esctb.restapiserver.domain.user.dto.UserDto.*;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    //회원가입
    @PostMapping("/join")
    public ApiResponse<UserInfo> join(@RequestBody UserJoinRequestDto joinRequestDto){
        UserInfo joinResponse = userService.join(joinRequestDto);
        return ApiResponse.createSuccess(joinResponse);
    }

    //로그인
    @PostMapping("/login")
    public ApiResponse<User> login(@RequestBody UserLoginDto loginDto){
        User loginResponse = userService.getMemberLoginCheck(loginDto);
        return ApiResponse.createSuccess(loginResponse);
    }
}
