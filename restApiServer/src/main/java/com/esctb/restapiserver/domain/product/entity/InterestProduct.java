package com.esctb.restapiserver.domain.product.entity;

import com.esctb.restapiserver.domain.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class InterestProduct extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "interest_product_id")
    private Long id;
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public static InterestProduct createInterestProduct(Long userId, Product product) {
        return InterestProduct.builder()
                .userId(userId)
                .product(product)
                .build();
    }
}
