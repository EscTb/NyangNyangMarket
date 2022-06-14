package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.product.dto.ProductDto;

import java.util.List;

public interface MyPageService {
    List<ProductDto> getMyPurchaseHistory(String userId);
    List<ProductDto> getMySalesHistory(String userId);
}
