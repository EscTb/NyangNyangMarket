package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.*;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.model.ProductStatus;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.esctb.restapiserver.global.error.ErrorCode.PRODUCT_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> result = productList.stream()
                .map(p -> ProductDto.builder()
                        .id(p.getId())
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

    public Optional<Product> findByProductId(Long productId) {
        return productRepository.findById(productId);
    }

    public ProductDetailDto findDetailProductByProductId(Long productId) {
        Optional<Product> p = productRepository.findById(productId);

        if (p.isPresent()) {
            Product product = p.get();
            ProductDetailDto result = ProductDetailDto.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .content(product.getContent())
                    .interestCount(product.getInterestCount())
                    .status(product.getStatus())
                    .title(product.getTitle())
                    .viewCount(product.getViewCount())
                    .productImages(product.getProductImages())
                    .build();

            return result;
        }

        else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }
//        p.orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
    }

    public CreateProductResponse addProduct(ProductCreateRequest request) {
        Product newProduct = Product.builder()
                .price(request.getPrice())
                .title(request.getTitle())
                .content(request.getContent())
                .interestCount(0)
                .productImages(request.getProductImages())
                .viewCount(0)
                .refreshDate(LocalDateTime.now())
                .status(ProductStatus.SALE)
                .build();

        Product product = productRepository.save(newProduct);

        CreateProductResponse response = CreateProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .content(product.getContent())
                .interestCount(product.getInterestCount())
                .status(product.getStatus())
                .title(product.getTitle())
                .productImages(product.getProductImages())
                .viewCount(product.getViewCount())
                .build();
        return response;
    }

    public void deleteProduct(Long productId) {
        Optional<Product> byProductId = this.findByProductId(productId);
        byProductId.ifPresent(x->{productRepository.delete(x);});
        byProductId.orElseThrow(()->new CustomException(PRODUCT_NOT_FOUND));
    }

    public ProductDto updateProduct(Long productId, ProductUpdateRequestDto productUpdateRequestDto) {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            Product newProduct = ProductUpdateRequestDto.toEntity(productId, productUpdateRequestDto);
            Product saved = productRepository.save(newProduct);
            return ProductDto.builder()
                    .id(productId)
                    .viewCount(saved.getViewCount())
                    .title(saved.getTitle())
                    .status(saved.getStatus())
                    .interestCount(saved.getInterestCount())
                    .content(saved.getContent())
                    .price(saved.getPrice())
                    .content(saved.getContent())
                    .build();
        } else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }

    }
}
