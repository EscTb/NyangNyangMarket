package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.model.ProductStatusConverter;
import com.esctb.restapiserver.domain.product.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ProductDetailDto {
    private Long id;
    private String title;
    private int price;
    private String content;
    private int viewCount;
    private int interestCount;
    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus status;
    private List<ProductImage> productImages = new ArrayList<>();
}
