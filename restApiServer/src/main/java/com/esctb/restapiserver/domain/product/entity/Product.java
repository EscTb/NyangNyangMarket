package com.esctb.restapiserver.domain.product.entity;

import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.model.ProductStatusConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 직접 생성 막기
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
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


    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus status;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();
//    public static Product createProduct(List<ProductImage> productImages) {
//        Product product = Product.builder()
//                .id()
//                .content();
//
//        for (OrderItem orderItem : orderItems) {
//            product.addOrderItem(orderItem);
//        }
//        product.setStatus(ProductStatus.SALE);
//        product.setOrderDate(LocalDateTime.now());
//        return product;
//    }
}
