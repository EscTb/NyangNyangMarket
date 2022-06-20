package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.InterestProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductDto.CreateRequest;
import com.esctb.restapiserver.domain.product.dto.ProductDto.Detail;
import com.esctb.restapiserver.domain.product.entity.InterestProduct;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.repository.InterestProductRepository;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.esctb.restapiserver.global.error.ErrorCode.PRODUCT_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;
    private final InterestProductRepository interestProductRepository;
    public List<Detail> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(p -> Detail.builder().build().toDto(p))
                .collect(Collectors.toList());
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

    public ProductDto.CreateResponse addProduct(CreateRequest request) {
        Product newProduct = request.toEntity(request);
        Product product = productRepository.save(newProduct);
        return ProductDto.CreateResponse.builder().build().toDto(product);
    }

    public void deleteProduct(Long productId) {
        Optional<Product> byProductId = this.findByProductId(productId);
        byProductId.ifPresent(productRepository::delete);
        byProductId.orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
    }

    public Detail updateProduct(Long productId, ProductDto.UpdateRequest request) {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            Product newProduct = ProductDto.UpdateRequest.toEntity(productId, request);
            Product saved = productRepository.save(newProduct);
            return Detail.builder().build().toDto(saved);
        } else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }
    }

    public List<Detail> findProductsByCategoryId(Long categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId);
        return productList.stream()
                .map(p -> Detail.builder().build().toDto(p))
                .collect(Collectors.toList());
    }

    public InterestProductDto.CreateResponse addInterestProduct(Long productId, Long userId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            InterestProduct interestProduct = InterestProduct.createInterestProduct(userId, product.get());
            InterestProduct saved = interestProductRepository.save(interestProduct);
            return InterestProductDto.CreateResponse.builder().build().toDto(saved);
        } else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }
    }
}
