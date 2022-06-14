package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.dto.LoginDto;
import com.esctb.restapiserver.domain.user.dto.UserDto;
import com.esctb.restapiserver.domain.user.dto.joinUserRequestDto;
import com.esctb.restapiserver.domain.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {

    Long join(joinUserRequestDto requestUserDto);
    UserDto getMemberLoginCheck(LoginDto loginDto);
}
