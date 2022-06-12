package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.model.ProductStatusConverter;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ProductUpdateRequestDto {
    @NotNull
    private String title;
    @NotNull
    private int price;
    @NotNull
    private String content;
    private LocalDateTime refreshDate;
    @NotNull
    private int viewCount;
    @NotNull
    private int interestCount;

    @Convert(converter = ProductStatusConverter.class)
    @NotNull
    private ProductStatus status;

    public static Product toEntity(Long productId,ProductUpdateRequestDto dto) {
        return Product.builder()
                .id(productId)
                .price(dto.getPrice())
                .title(dto.getTitle())
                .interestCount(dto.getInterestCount())
                .content(dto.getContent())
                .status(dto.getStatus())
                .viewCount(dto.getViewCount())
                .refreshDate(LocalDateTime.now())
                .build();
    }
}
