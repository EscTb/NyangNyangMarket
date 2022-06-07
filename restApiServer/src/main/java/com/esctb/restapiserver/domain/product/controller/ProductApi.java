package com.esctb.restapiserver.domain.product.controller;

import com.esctb.restapiserver.domain.product.dto.CreateProductResponse;
import com.esctb.restapiserver.domain.product.dto.ProductCreateRequest;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
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
    public List<ProductDto> readProducts() {
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
    public ProductDto readProduct(@PathVariable Long productId) {
        Optional<Product> p = productService.findByProductId(productId);
        if (p != null) {
            ProductDto result = ProductDto.builder()
                    .price(p.get().getPrice())
                    .content(p.get().getContent())
                    .interestCount(p.get().getInterestCount())
                    .status(p.get().getStatus())
                    .title(p.get().getTitle())
                    .viewCount(p.get().getViewCount())
                    .build();
            return result;
        } else {
            return null; // TODO throw ProductNotFoundException
        }
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
    @PatchMapping("products/{productId}")
    public ProductDto patchProduct(@PathVariable Long productId,
                             @RequestParam String column,
                             @RequestParam String tobe) {

        return productService.patchProduct(productId, column, tobe);

    }
}
