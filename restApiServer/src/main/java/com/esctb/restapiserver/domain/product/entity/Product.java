package com.esctb.restapiserver.domain.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @Column(name = "product_id")
    private Long id;

    // TODO 추후 개발 완료 되면 연관관계 설정
    //private String userId;
    //private String categoryId;
    //private String areaId;
    private String title;
    private int price;
    //private String areaId;
    private String content;
    private LocalDateTime refreshDate;
    private int viewCount;
    private int interestCount;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}
