package com.esctb.restapiserver.domain.user.service;

import static com.esctb.restapiserver.domain.product.dto.ProductDtoTest.*;

import java.util.List;

public interface MyPageService {
    List<Detail> getMyPurchaseHistory(String userId);
    List<Detail> getMySalesHistory(String userId);
}
