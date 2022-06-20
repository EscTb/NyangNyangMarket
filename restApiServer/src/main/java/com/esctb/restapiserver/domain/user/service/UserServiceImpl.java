package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.dto.LoginDto;
import com.esctb.restapiserver.domain.user.dto.UserDto;
import com.esctb.restapiserver.domain.user.dto.joinUserRequestDto;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.repository.UserRepository;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.esctb.restapiserver.global.error.ErrorCode.MEMBER_NOT_FOUND;

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

    //로그인
    public User getMemberLoginCheck(LoginDto loginDto){

        Optional<User> result = userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        User user = result.get();

        if(user!=null)
            return user;
        else
            throw new CustomException(MEMBER_NOT_FOUND);
    }
}
