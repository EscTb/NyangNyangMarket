package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.entity.SalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesHistoryRepository extends JpaRepository<SalesHistory, Long> {
}
