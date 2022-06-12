package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원 가입
    @Transactional //false가 기본값
    public Long join(User user){
        userRepository.save(user);
        return user.getId();
    }

    //회원 정보 조회
    public User findOne(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
}
