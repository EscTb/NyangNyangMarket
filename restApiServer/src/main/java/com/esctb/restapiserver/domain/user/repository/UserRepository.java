package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.dto.UserDto;
import com.esctb.restapiserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<UserDto> findByEmailAndPassword(String email, String pwd);
}
