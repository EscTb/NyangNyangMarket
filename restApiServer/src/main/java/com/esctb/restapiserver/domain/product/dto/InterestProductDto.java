package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.product.entity.InterestProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class InterestProductDto {

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    public static class CreateResponse {
        private Long userId;
        private Long productId;
//        private List<Product> products= new ArrayList<>();

        public CreateResponse toDto(InterestProduct entity) {
            return CreateResponse.builder()
                    .userId(entity.getUserId())
                    .productId(entity.getProduct().getId())
                    .build();
        }
    }

}
