package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);

    Optional<User> findByEmailAndPassword(String email, String pwd);
}
