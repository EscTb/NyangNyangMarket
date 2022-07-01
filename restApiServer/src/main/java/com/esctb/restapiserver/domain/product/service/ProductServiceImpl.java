package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.InterestProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductDto.CreateRequest;
import com.esctb.restapiserver.domain.product.dto.ProductDto.Detail;
import com.esctb.restapiserver.domain.product.entity.InterestProduct;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.entity.ProductImage;
import com.esctb.restapiserver.domain.product.repository.InterestProductRepository;
import com.esctb.restapiserver.domain.product.repository.ProductImageRepository;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.repository.UserRepository;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.esctb.restapiserver.domain.product.entity.InterestProduct.createInterestProduct;
import static com.esctb.restapiserver.global.error.ErrorCode.PRODUCT_NOT_FOUND;
import static com.esctb.restapiserver.global.error.ErrorCode.USER_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final InterestProductRepository interestProductRepository;
    private final UserRepository userRepository;

    public List<Detail> findAllProducts() {
        List<Product> productList = productRepository.findAllProducts();
        return productList.stream()
                .map(p -> Detail.builder().build().toDto(p))
                .collect(Collectors.toList());
    }

    public Optional<Product> findByProductId(Long productId) {
        return productRepository.findById(productId);
    }

    public Detail findDetailProductByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
        return Detail.builder().build().toDto(product);

    }

    public ProductDto.CreateResponse addProduct(CreateRequest request) {
        Product newProduct = request.toEntity(request);
        List<ProductImage> productImages = request.getProductImages();

        for (ProductImage productImage : productImages) {
            productImageRepository.save(productImage);
            productImage.addProduct(newProduct);
            //newProduct.addProductImage(productImage);
        }
        Product product = productRepository.save(newProduct);
        return ProductDto.CreateResponse.builder().build().toDto(product);
    }

    public void deleteProduct(Long productId) {
        Product product = this.findByProductId(productId)
                .orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }

    public Detail updateProduct(Long productId, ProductDto.UpdateRequest request) {
//        Product productById = productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
        Product newProduct = ProductDto.UpdateRequest.toEntity(productId, request);
        Product saved = productRepository.save(newProduct);
        return Detail.builder().build().toDto(saved);

    }

    public List<Detail> findProductsByCategoryId(Long categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId);
        return productList.stream()
                .map(p -> Detail.builder().build().toDto(p))
                .collect(Collectors.toList());
    }

    public InterestProductDto.CreateResponse addInterestProduct(Long productId, Long userId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
        User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        InterestProduct interestProduct = createInterestProduct(userId, product);
        InterestProduct saved = interestProductRepository.save(interestProduct);
        productRepository.save(product);
        userRepository.save(user);
        return InterestProductDto.CreateResponse.builder().build().toDto(saved);

    }
}
