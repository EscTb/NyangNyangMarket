package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.product.entity.Category;
import com.esctb.restapiserver.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    public static class Detail {
        private Long id;
        private String name;
        private List<Product> productList = new ArrayList<>();

        public CategoryDto.Detail toDto(Category entity) {
            return CategoryDto.Detail.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
        }
    }
}
