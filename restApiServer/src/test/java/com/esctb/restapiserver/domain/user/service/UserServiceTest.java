package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
class UserServiceTest {

    @Autowired UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;

    @Test
    public void join() throws Exception{

/*        User user = User.builder()
                .name("뚱이")
                .nickname("냥")
                .build();
        Long saveId = userServiceImpl.join(user);
        System.out.println("saveId: "+saveId);
        
        User user1 = userServiceImpl.findOne(saveId);
        System.out.println("user1.getName() = " + user1.getName());

        assertEquals(Optional.of(user), userRepository.findById(saveId));*/
    }

}