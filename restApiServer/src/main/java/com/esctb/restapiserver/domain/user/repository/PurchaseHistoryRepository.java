package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long>{
    List<Long> findByUserId(String email);
}
