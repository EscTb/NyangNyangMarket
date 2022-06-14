package com.esctb.restapiserver.domain.user.controller;

import com.esctb.restapiserver.domain.product.service.ProductService;
import com.esctb.restapiserver.domain.user.repository.PurchaseHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0")
@RequiredArgsConstructor
public class MyPageApi {
    private final ProductService productService;
}
