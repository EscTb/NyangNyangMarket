package com.esctb.restapiserver.domain.user.repository;

import com.esctb.restapiserver.domain.user.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long>{
}
