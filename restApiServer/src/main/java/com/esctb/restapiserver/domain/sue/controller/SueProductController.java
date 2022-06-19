package com.esctb.restapiserver.domain.sue.controller;

import com.esctb.restapiserver.domain.sue.service.SueProductService;
import com.esctb.restapiserver.global.common.ApiResponse;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse getAllSueProductByProductId(@PathVariable Long product_id){
        try {
            return ApiResponse.createSuccess(sueProductService.getSueproductListByProductId(product_id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

    @GetMapping("users/{user_Id}")
    public ApiResponse getAllSueProductByUserId(@PathVariable Long user_id){
        try {
            return ApiResponse.createSuccess(sueProductService.getSueproductListByUserId(user_id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

    @DeleteMapping("/products/{product_id}")
    public ApiResponse deleteAllSueProductByProductId(@PathVariable Long product_id){
        try {
            return ApiResponse.createSuccess(sueProductService.deleteAllSueProductByProductId(product_id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

    @DeleteMapping("users/{user_Id}")
    public ApiResponse deleteAllSueProductByUserId(@PathVariable Long user_id){
        try {
            return ApiResponse.createSuccess(sueProductService.deleteAllSueProductByUserId(user_id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

}
