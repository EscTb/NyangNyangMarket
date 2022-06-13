package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.model.ProductStatusConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private String content;
    private int viewCount;
    private int interestCount;
    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus status;
}
