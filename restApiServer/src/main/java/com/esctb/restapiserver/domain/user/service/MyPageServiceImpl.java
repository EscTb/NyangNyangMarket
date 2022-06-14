package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.domain.user.repository.PurchaseHistoryRepository;
import com.esctb.restapiserver.domain.user.repository.SalesHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final SalesHistoryRepository salesHistoryRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getMyPurchaseHistory(String userId) {
        List<Long> productIdList = purchaseHistoryRepository.findByUserId(userId); //user_id가 userId인 상품Id 목록
        List<ProductDto> productDtoList = null;
        for(Long productId : productIdList){
            Optional<Product> result = productRepository.findById(productId);
            Product product = result.get();
            ProductDto productDto = ProductDto.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .content(product.getContent())
                    .interestCount(product.getInterestCount())
                    .status(product.getStatus())
                    .title(product.getTitle())
                    .viewCount(product.getViewCount())
                    .build();
            productDtoList.add(productDto);
        }
        return null;
    }

    @Override
    public List<ProductDto> getMySalesHistory(String userId) {
        return null;
    }
}
