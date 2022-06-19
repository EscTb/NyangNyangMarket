package com.esctb.restapiserver.domain.user.controller;

import com.esctb.restapiserver.domain.user.service.MyPageService;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.esctb.restapiserver.domain.product.dto.ProductDto.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class MyPageApi {
    private final MyPageService myPageService;

    @GetMapping("/purchases/{userEmail}")
    public ApiResponse<List<Detail>> getMyPurchasedProducts(@PathVariable String userEmail) {
        List<Detail> productList = myPageService.getMyPurchaseHistory(userEmail);
        return ApiResponse.createSuccess(productList);
    }

    @GetMapping("/sales/{userEmail}")
    public ApiResponse<List<Detail>> getMySoldProducts(@PathVariable String userEmail) {
        List<Detail> productList = myPageService.getMySalesHistory(userEmail);
        return ApiResponse.createSuccess(productList);
    }
}
