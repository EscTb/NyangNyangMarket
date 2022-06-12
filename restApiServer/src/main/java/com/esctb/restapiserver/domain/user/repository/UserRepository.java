package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
