package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.ProductCreateRequest;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.entity.ProductStatus;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.esctb.restapiserver.global.error.ErrorCode.PRODUCT_NOT_FOUND;
@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findByProductId(Long productId) {
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

    public void deleteProduct(Long productId) {
        Optional<Product> byProductId = this.findByProductId(productId);

        if (byProductId.isPresent()) {
            productRepository.delete(byProductId.get());
        } else {
            throw new CustomException(PRODUCT_NOT_FOUND);
        }
    }

    public ProductDto patchProduct(Long productId, String column, String tobe) {
        Optional<Product> productById = productRepository.findById(productId);
        productById.get();
      //  Product newProduct = Product.builder().price(productById)
       // productRepository.save(productById.get().);
        return null;
    }
}
