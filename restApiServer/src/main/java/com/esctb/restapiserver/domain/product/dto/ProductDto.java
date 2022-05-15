package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.product.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ProductDto {
    private String title;
    private int price;
    private String content;
    private int viewCount;
    private int interestCount;
    private ProductStatus status;
}
