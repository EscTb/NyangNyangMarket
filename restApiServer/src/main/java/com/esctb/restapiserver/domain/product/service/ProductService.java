package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.*;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.esctb.restapiserver.domain.product.dto.ProductDto.*;
import static com.esctb.restapiserver.global.error.ErrorCode.PRODUCT_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Detail> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<Detail> result = productList.stream()
                .map(p -> Detail.builder().build().toDto(p))
                .collect(Collectors.toList());
        return result;
    }

    public Optional<Product> findByProductId(Long productId) {
        return productRepository.findById(productId);
    }

    public Detail findDetailProductByProductId(Long productId) {
        Optional<Product> p = productRepository.findById(productId);

        if (p.isPresent()) {
            Product product = p.get();
            return Detail.builder().build().toDto(product);
        } else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }
    }

    public CreateResponse addProduct(ProductDto.CreateRequest request) {
        Product newProduct = request.toEntity(request);
        Product product = productRepository.save(newProduct);
        CreateResponse response = CreateResponse.builder().build().toEntity(product);
        return response;
    }

    public void deleteProduct(Long productId) {
        Optional<Product> byProductId = this.findByProductId(productId);
        byProductId.ifPresent(productRepository::delete);
        byProductId.orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
    }

    public Detail updateProduct(Long productId, UpdateRequest request) {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            Product newProduct = UpdateRequest.toEntity(productId, request);
            Product saved = productRepository.save(newProduct);
            return Detail.builder().build().toDto(saved);
        } else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }
    }
}
