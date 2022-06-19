package com.esctb.restapiserver.domain.product.api;

import com.esctb.restapiserver.domain.product.dto.InterestProductDto;
import com.esctb.restapiserver.domain.product.service.ProductService;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.esctb.restapiserver.domain.product.dto.ProductDto.*;

@Slf4j
@ResponseBody
@RequiredArgsConstructor
@Controller
@RequestMapping("api/v1.0/products")
public class ProductApi {

    private final ProductService productService;

    /**
     * 매물 등록
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CreateResponse> createProduct(@RequestBody @Valid CreateRequest request) {
        CreateResponse response = productService.addProduct(request);
        return ApiResponse.createSuccess(response);
    }

    /**
     * 전체 매물 조회
     */
    @GetMapping
    public ApiResponse<List<Detail>> readProducts() {
        List<Detail> productList = productService.findAllProducts();
        return ApiResponse.createSuccess(productList);
    }

    /**
     * 매물 상세 조회
     */
    @GetMapping("{productId}")
    public ApiResponse<Detail> readProduct(@PathVariable Long productId) {
        Detail response = productService.findDetailProductByProductId(productId);
        return ApiResponse.createSuccess(response);
    }

    /**
     * 매물 삭제
     *
     * @return
     */
    @DeleteMapping("{productId}")
    public ApiResponse<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ApiResponse.createSuccessWithNoContent();
    }

    /**
     * 매물 수정
     */
    @PostMapping("{productId}")
    public ApiResponse<Detail> updateProduct(@PathVariable Long productId,
                                             @RequestBody @Valid UpdateRequest request) {
        Detail response = productService.updateProduct(productId, request);
        return ApiResponse.createSuccess(response);
    }

    /**
     * 특정 카테고리 매물 조회
     */
    @GetMapping("category/{categoryId}")
    public ApiResponse<List<Detail>> readProductsInCategory(@PathVariable Long categoryId) {
        List<Detail> productList = productService.findProductsByCategoryId(categoryId);
        return ApiResponse.createSuccess(productList);
    }

    /**
     * 관심 상품 등록
     */
    @PostMapping("{productId}/users/{userId}")
    public ApiResponse<InterestProductDto.CreateResponse> addInterestProduct(@PathVariable Long productId, @PathVariable Long userId) {
        InterestProductDto.CreateResponse dto = productService.addInterestProduct(productId, userId);
        return ApiResponse.createSuccess(dto);

    }
}
