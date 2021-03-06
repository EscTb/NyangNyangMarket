package com.esctb.restapiserver.domain.product.dto;

import com.esctb.restapiserver.domain.product.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ProductCreateRequest {
    private String title;
    private int price;
    //private String areaId;
    private String content;
    private List<ProductImage> productImages = new ArrayList<>();

}
