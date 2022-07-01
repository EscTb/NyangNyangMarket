package com.esctb.restapiserver.domain.product.repository;

import com.esctb.restapiserver.domain.product.entity.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.esctb.restapiserver.domain.category.entity.QCategory.category;
import static com.esctb.restapiserver.domain.product.entity.QProduct.product;
import static com.esctb.restapiserver.domain.product.entity.QProductImage.productImage;
@Slf4j
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
                .leftJoin(product.category, category)
                .fetch();
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> fetch = queryFactory
                .selectFrom(product)
                .join(product.productImages, productImage)
                .fetch();
        log.info("fetch={}",fetch);
        return fetch;
    }
}
