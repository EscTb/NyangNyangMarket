package com.esctb.restapiserver.domain.product.controller;

import com.esctb.restapiserver.domain.product.service.ProductService;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.dto.CreateProductResponse;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("v1.0")
public class ProductApi {

    private final ProductService productService;

    /**
     * 매물 등록
     */
    @PostMapping("products")
    public CreateProductResponse add(@RequestBody @Valid ProductCreateRequest productRequest) {
        Product product = productService.addProduct(productRequest);
        CreateProductResponse response = CreateProductResponse.builder()
                .price(product.getPrice())
                .content(product.getContent())
                .interestCount(product.getInterestCount())
                .status(product.getStatus())
                .title(product.getTitle())
                .viewCount(product.getViewCount())
                .build();
        return response;
    }

    /**
     * 전체 매물 조회
     */
    @GetMapping("products")
    public List<ProductDto> getAll() {
        List<Product> productList = productService.findAllProducts();
        List<ProductDto> result = productList.stream()
                .map(p -> ProductDto.builder()
                        .price(p.getPrice())
                        .content(p.getContent())
                        .interestCount(p.getInterestCount())
                        .status(p.getStatus())
                        .title(p.getTitle())
                        .viewCount(p.getViewCount())
                        .build())
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 매물 상세 조회
     */
    @GetMapping("products/{productId}")
    public ProductDto detail(String productId) {
        Product p = productService.findByProductId(productId);
        ProductDto result = ProductDto.builder()
                .price(p.getPrice())
                .content(p.getContent())
                .interestCount(p.getInterestCount())
                .status(p.getStatus())
                .title(p.getTitle())
                .viewCount(p.getViewCount())
                .build();
        return result;
    }

    /**
     * 매물 삭제
     */
    @DeleteMapping("products/{productId}")
    public void delete(String productId) {

    }

    /**
     * 매물 수정
     */
    @PatchMapping("products/{productId}")
    public void update(String productId) {

    }
}
