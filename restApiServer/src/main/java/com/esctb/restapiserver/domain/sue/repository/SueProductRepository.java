package com.esctb.restapiserver.domain.sue.repository;

import com.esctb.restapiserver.domain.sue.entity.SueProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SueProductRepository extends JpaRepository<SueProduct, Long> {
    Optional<List<SueProduct>> findAllByProductId(Long productId);
}
