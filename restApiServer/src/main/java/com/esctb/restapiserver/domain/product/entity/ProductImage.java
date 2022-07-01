package com.esctb.restapiserver.domain.product.entity;

import com.esctb.restapiserver.domain.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductImage extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "product_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String imageName; // 이미지명
    private String imagePath; // 이미지 경로

    public void setProduct(Product product) {
        this.product = product;
    }

    public void addProduct(Product product) {
        if (this.product!=null){
            this.product = null;
        }
        this.product = product;
    }
}
