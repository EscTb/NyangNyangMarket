package com.esctb.restapiserver.user.repository;

import com.esctb.restapiserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
