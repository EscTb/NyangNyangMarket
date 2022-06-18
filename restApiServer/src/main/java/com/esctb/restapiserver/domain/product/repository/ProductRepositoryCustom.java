package com.esctb.restapiserver.domain.product.repository;

import com.esctb.restapiserver.domain.product.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryCustom {
    List<Product> findByCategoryId(Long categoryId);

}
