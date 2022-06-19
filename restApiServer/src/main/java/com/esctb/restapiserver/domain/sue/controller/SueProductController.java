package com.esctb.restapiserver.domain.sue.controller;

import com.esctb.restapiserver.domain.sue.service.SueProductService;
import com.esctb.restapiserver.global.common.ApiResponse;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/sue-product")
public class SueProductController {

    private SueProductService sueProductService;

    @GetMapping("/{id}")
    public ApiResponse getSueProduct(@PathVariable Long id){
        try {
            return ApiResponse.createSuccess(sueProductService.getSueProduct(id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

    @GetMapping("/products/{product_id}")
    public ApiResponse getSueProductListByProductId(@PathVariable Long product_id){
        try {
            return ApiResponse.createSuccess(sueProductService.getSueproductListByProductId(product_id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }
}
