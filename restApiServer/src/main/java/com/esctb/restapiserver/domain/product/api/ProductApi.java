package com.esctb.restapiserver.domain.product.api;

import com.esctb.restapiserver.domain.product.dto.*;
import com.esctb.restapiserver.domain.product.service.ProductService;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ResponseBody
@RequiredArgsConstructor
@Controller
@RequestMapping("api/v1.0")
public class ProductApi {

    private final ProductService productService;

    /**
     * 매물 등록
     */
    @PostMapping("products")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CreateProductResponse> createProduct(@RequestBody @Valid ProductCreateRequest productRequest) {
        CreateProductResponse response = productService.addProduct(productRequest);
        return ApiResponse.createSuccess(response);
    }

    /**
     * 전체 매물 조회
     */
    @GetMapping("products")
    public ApiResponse<List<ProductDto>> readProducts() {
        List<ProductDto> productList = productService.findAllProducts();
        return ApiResponse.createSuccess(productList);
    }

    /**
     * 매물 상세 조회
     */
    @GetMapping("products/{productId}")
    public ApiResponse<ProductDetailDto> readProduct(@PathVariable Long productId) {
        ProductDetailDto response = productService.findDetailProductByProductId(productId);
        return ApiResponse.createSuccess(response);
    }

    /**
     * 매물 삭제
     * @return
     */
    @DeleteMapping("products/{productId}")
    public ApiResponse<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ApiResponse.createSuccessWithNoContent();
    }

    /**
     * 매물 수정
     */
    @PostMapping("products/{productId}")
    public ApiResponse<ProductDto> updateProduct(@PathVariable Long productId,
                                                 @RequestBody @Valid ProductUpdateRequestDto productUpdateRequestDto) {
        ProductDto response = productService.updateProduct(productId, productUpdateRequestDto);
        return ApiResponse.createSuccess(response);
    }
}
