package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.entity.User;

import com.esctb.restapiserver.domain.user.dto.UserDto.*;

public interface UserService {

    UserInfo join(UserJoinRequestDto joinRequestDto);
    User getMemberLoginCheck(UserLoginDto loginDto);
}
