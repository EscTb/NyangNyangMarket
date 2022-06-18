package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.model.ProductStatusConverter;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.entity.ProductImage;
import lombok.*;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDtoTest {

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    //@Data
    public static class Detail {
        private Long id;
        private String title;
        private int price;
        private String content;
        private int viewCount;
        private int interestCount;
        @Convert(converter = ProductStatusConverter.class)
        private ProductStatus status;
        private List<ProductImage> productImages = new ArrayList<>();

        public Detail toDto(Product product){
            return Detail.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .content(product.getContent())
                    .interestCount(product.getInterestCount())
                    .status(product.getStatus())
                    .title(product.getTitle())
                    .viewCount(product.getViewCount())
                    //.productImages(product.getProductImages())
                    .build();
        }

    }

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    //@Data
    public static class UpdateRequest {
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

        public static Product toEntity(Long productId, UpdateRequest dto) {
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

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    public static class CreateRequest {
        private String title;
        private int price;
        //private String areaId;
        private String content;
        private List<ProductImage> productImages = new ArrayList<>();
        public static Product toEntity(CreateRequest request) {
            return Product.builder()
                    .price(request.getPrice())
                    .title(request.getTitle())
                    .content(request.getContent())
                    .interestCount(0)
                    .productImages(request.getProductImages())
                    .viewCount(0)
                    .refreshDate(LocalDateTime.now())
                    .status(ProductStatus.SALE)
                    .build();
        }

    }

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    public static class CreateResponse {
        private Long id;
        private String title;
        private int price;
        private String content;
        private int viewCount;
        private int interestCount;
        @Convert(converter = ProductStatusConverter.class)
        private ProductStatus status;
        private List<ProductImage> productImages = new ArrayList<>();

        public static CreateResponse toEntity(Product product) {
            return CreateResponse.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .content(product.getContent())
                    .interestCount(product.getInterestCount())
                    .status(product.getStatus())
                    .title(product.getTitle())
                    .productImages(product.getProductImages())
                    .viewCount(product.getViewCount())
                    .build();
        }
    }
}
