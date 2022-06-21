package com.esctb.restapiserver.domain.product.repository;

import com.esctb.restapiserver.domain.product.entity.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.esctb.restapiserver.domain.product.entity.QCategory.category;
import static com.esctb.restapiserver.domain.product.entity.QProduct.product;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        return queryFactory
                .select(product)
                .from(product)
                .leftJoin(product.category,category)
                .fetch();
    }
}
