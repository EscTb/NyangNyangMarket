package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.entity.ProductStatus;
import com.esctb.restapiserver.domain.product.dto.ProductCreateRequest;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findByProductId(String productId) {
        return productRepository.findById(productId);
    }

    public Product addProduct(ProductCreateRequest request) {
        Product newProduct = Product.builder()
                .price(request.getPrice())
                .title(request.getTitle())
                .content(request.getContent())
                .interestCount(0)
                .viewCount(0)
                .refreshDate(LocalDateTime.now())
                .status(ProductStatus.SALE)
                .build();

        return productRepository.save(newProduct);
    }
}
