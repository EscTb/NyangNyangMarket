package com.esctb.restapiserver.domain.sue.service;

import com.esctb.restapiserver.domain.sue.dto.SueProductDto;
import com.esctb.restapiserver.domain.sue.repository.SueProductRepository;
import com.esctb.restapiserver.global.error.ErrorCode;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SueProductServiceImpl implements SueProductService{

    private final SueProductRepository sueProductRepository;


    @Override
    public SueProductDto.SueProductResponse getSueProduct(Long id) {
        return SueProductDto.SueProductResponse.builder().build().toResponse(
                sueProductRepository.findById(id).orElseThrow(()->new CustomException(ErrorCode.SUE_PRODUCT_NOT_FOUND))
        );
    }

    @Override
    public List<SueProductDto.SueProductResponse> getSueproductListByProductId(Long productId) {
        return sueProductRepository.findAllByProductId(productId)
                .orElseThrow(()->new CustomException(ErrorCode.SUE_PRODUCT_NOT_FOUND))
                .stream()
                .map(sueProduct ->
                        SueProductDto.SueProductResponse
                        .builder()
                        .build()
                        .toResponse(sueProduct)
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<SueProductDto.SueProductResponse> getSueproductListByUserId(Long userId) {
        return sueProductRepository.findAllByUserId(userId)
                .orElseThrow(()->new CustomException(ErrorCode.SUE_PRODUCT_NOT_FOUND))
                .stream()
                .map(sueProduct ->
                        SueProductDto.SueProductResponse
                                .builder()
                                .build()
                                .toResponse(sueProduct)
                )
                .collect(Collectors.toList());
    }

    @Override
    public SueProductDto.SueProductDeleteSuccessResponse deleteAllSueProductByProductId(Long productId) {
        sueProductRepository.findAllByProductId(productId).orElseThrow(()->new CustomException(ErrorCode.SUE_PRODUCT_NOT_FOUND));
        sueProductRepository.deleteAllByProductId(productId);
        return SueProductDto.SueProductDeleteSuccessResponse.builder().build();
    }

    @Override
    public SueProductDto.SueProductDeleteSuccessResponse deleteAllSueProductByUserId(Long userId) {
        sueProductRepository.findAllByUserId(userId).orElseThrow(()->new CustomException(ErrorCode.SUE_PRODUCT_NOT_FOUND));
        sueProductRepository.deleteAllByUserId(userId);
        return SueProductDto.SueProductDeleteSuccessResponse.builder().build();
    }
}
