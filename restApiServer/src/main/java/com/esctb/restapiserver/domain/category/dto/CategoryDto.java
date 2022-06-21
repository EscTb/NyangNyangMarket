package com.esctb.restapiserver.domain.category.dto;

import com.esctb.restapiserver.domain.category.entity.Category;
import com.esctb.restapiserver.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
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

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String name;

        public CategoryDto.Response toDto(Category entity) {
            return CategoryDto.Response.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
        }
    }
}
