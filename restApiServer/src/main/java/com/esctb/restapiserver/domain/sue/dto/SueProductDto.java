package com.esctb.restapiserver.domain.sue.dto;

import com.esctb.restapiserver.domain.sue.entity.SueProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

public class SueProductDto {

    @NoArgsConstructor
    @Getter
    @Builder
    @AllArgsConstructor
    public static class SueProductResponse{
        private Long id;
        private Long userId;
        private Long productId;
        private Date createDate;

        public SueProductResponse toResponse(SueProduct sueProduct){
            return SueProductResponse.builder()
                    .id(sueProduct.getId())
                    .userId(sueProduct.getUser().getId())
                    .productId(sueProduct.getProduct().getId())
                    .createDate(sueProduct.getCreateDate())
                    .build();
        }
    }
}
