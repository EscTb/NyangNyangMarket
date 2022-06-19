package com.esctb.restapiserver.domain.sue.service;

import com.esctb.restapiserver.domain.sue.dto.SueProductDto;

import java.util.List;

public interface SueProductService {
    SueProductDto.SueProductResponse getSueProduct(Long id);
    List<SueProductDto.SueProductResponse> getSueproductListByProductId(Long productId);
    List<SueProductDto.SueProductResponse> getSueproductListByUserId(Long userId);
    SueProductDto.SueProductDeleteSuccessResponse deleteAllSueProductByProductId(Long productId);
    SueProductDto.SueProductDeleteSuccessResponse deleteAllSueProductByUserId(Long userId);
}
