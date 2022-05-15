package com.esctb.restapiserver.domain.product.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@NoArgsConstructor

@Entity
public class ProductImage {
    @Id
    @GeneratedValue
    @Column(name = "product_image_id")
    private Long id;
    private String productId;
    private String imageName; // 이미지명
    private String imagePath; // 이미지 경로
}
