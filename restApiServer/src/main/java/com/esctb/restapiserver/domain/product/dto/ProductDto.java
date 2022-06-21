package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.model.ProductStatusConverter;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
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

        public Detail toDto(Product entity) {
            return Detail.builder()
                    .id(entity.getId())
                    .price(entity.getPrice())
                    .content(entity.getContent())
                    .status(entity.getStatus())
                    .title(entity.getTitle())
                    .viewCount(entity.getViewCount())
                    .productImages(entity.getProductImages())
//                    .interestCount(entity.getInterestProducts().size())
                    .build();
        }
    }

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
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
//        @NotNull
//        private int interestCount;

        @Convert(converter = ProductStatusConverter.class)
        @NotNull
        private ProductStatus status;

        public static Product toEntity(Long productId, UpdateRequest dto) {
            return Product.builder()
                    .id(productId)
                    .price(dto.getPrice())
                    .title(dto.getTitle())
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
        @NotNull
        private String title;
        @NotNull
        private int price;
        //private String areaId;
        @NotNull
        private String content;

        private List<ProductImage> productImages = new ArrayList<>();

        public static Product toEntity(CreateRequest dto) {
            return Product.builder()
                    .price(dto.getPrice())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .productImages(dto.getProductImages())
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
        private List<ProductImageDto> productImages = new ArrayList<>();

        public static CreateResponse toDto(Product entity) {

            List<ProductImageDto> productImages = entity.getProductImages()
                    .stream()
                    .map(productImage -> ProductImageDto.builder().build().toDto(productImage))
                    .collect(Collectors.toList());

            return CreateResponse.builder()
                    .id(entity.getId())
                    .price(entity.getPrice())
                    .interestCount(0)
                    .content(entity.getContent())
                    .status(entity.getStatus())
                    .title(entity.getTitle())
                    .productImages(productImages)
                    .viewCount(entity.getViewCount())
                    .build();
        }
    }


    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    public static class ProductImageDto {
        private Long id;
        private String imageName;
        private String imagePath;

        public static ProductImageDto toDto(ProductImage entity) {
            return ProductImageDto.builder()
                    .id(entity.getId())
                    .imageName(entity.getImageName())
                    .imagePath(entity.getImagePath())
                    .build();
        }
    }
}
