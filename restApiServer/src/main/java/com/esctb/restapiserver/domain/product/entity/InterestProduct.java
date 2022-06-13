package com.esctb.restapiserver.domain.product.entity;

import com.esctb.restapiserver.domain.model.BaseTimeEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@NoArgsConstructor
@Entity
public class InterestProduct extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "interest_product_id")
    private Long id;
    private String userId;
    private String productId;
}
