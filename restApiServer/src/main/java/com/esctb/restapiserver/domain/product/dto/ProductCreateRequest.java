package com.esctb.restapiserver.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ProductCreateRequest {
    private String title;
    private int price;
    //private String areaId;
    private String content;
}
