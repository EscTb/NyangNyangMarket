package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.InterestProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.dto.ProductDto.CreateRequest;
import com.esctb.restapiserver.domain.product.dto.ProductDto.CreateResponse;
import com.esctb.restapiserver.domain.product.dto.ProductDto.Detail;

import java.util.List;


public interface ProductService {

    List<Detail> findAllProducts();

    Detail findDetailProductByProductId(Long productId);

    CreateResponse addProduct(CreateRequest request);

    void deleteProduct(Long productId);

    Detail updateProduct(Long productId, ProductDto.UpdateRequest request);

    List<Detail> findProductsByCategoryId(Long categoryId);

    InterestProductDto.CreateResponse addInterestProduct(Long productId, Long userId);

}
