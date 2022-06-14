package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.dto.joinUserRequestDto;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    //회원 가입
    @Transactional
    public Long join(joinUserRequestDto userRequestDto){
        Long responseUserId = userRepository.save(userRequestDto.toEntity()).getId();
        return responseUserId;
    }

    //회원 정보 조회
    public User findOne(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
}
