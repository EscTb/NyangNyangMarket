package com.esctb.restapiserver.domain.product.controller;

import com.esctb.restapiserver.domain.product.dto.CreateProductResponse;
import com.esctb.restapiserver.domain.product.dto.ProductCreateRequest;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductUpdateRequestDto;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public CreateProductResponse createProduct(@RequestBody @Valid ProductCreateRequest productRequest) {
        CreateProductResponse response = productService.addProduct(productRequest);
        return response;
    }

    /**
     * 전체 매물 조회
     */
    @GetMapping("products")
    public List<ProductDto> readProducts() {
        List<ProductDto> productList = productService.findAllProducts();
        return productList;
    }

    /**
     * 매물 상세 조회
     */
    @GetMapping("products/{productId}")
    public ProductDto readProduct(@PathVariable Long productId) {
        return productService.findDetailProductByProductId(productId);
    }

    /**
     * 매물 삭제
     */
    @DeleteMapping("products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    /**
     * 매물 수정
     */
    @PostMapping("products/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId,
                                    @RequestBody @Valid ProductUpdateRequestDto productUpdateRequestDto) {
        return productService.patchProduct(productId, productUpdateRequestDto);
    }
}
