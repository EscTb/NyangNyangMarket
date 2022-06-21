package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.entity.PurchaseHistory;
import com.esctb.restapiserver.domain.user.entity.SalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesHistoryRepository extends JpaRepository<SalesHistory, Long> {
    List<SalesHistory> findByUserEmail(String email);
}
