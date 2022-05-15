package com.esctb.restapiserver.domain.product.repository;

import com.esctb.restapiserver.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    Product findById(String productId);
}
