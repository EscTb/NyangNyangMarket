package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.dto.joinUserRequestDto;
import com.esctb.restapiserver.domain.user.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    Long join(joinUserRequestDto requestUserDto);
    User findOne(Long userId);
}
