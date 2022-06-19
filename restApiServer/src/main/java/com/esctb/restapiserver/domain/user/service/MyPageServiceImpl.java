package com.esctb.restapiserver.domain.user.service;

import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.repository.ProductRepository;
import com.esctb.restapiserver.domain.user.entity.PurchaseHistory;
import com.esctb.restapiserver.domain.user.entity.SalesHistory;
import com.esctb.restapiserver.domain.user.repository.PurchaseHistoryRepository;
import com.esctb.restapiserver.domain.user.repository.SalesHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.esctb.restapiserver.domain.product.dto.ProductDto.*;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final SalesHistoryRepository salesHistoryRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Detail> getMyPurchaseHistory(String userEmail) {
        List<PurchaseHistory> purchaseHistoryList = purchaseHistoryRepository.findByUserEmail(userEmail);
        List<Detail> productDetailList = new ArrayList<Detail>();

        for(PurchaseHistory list : purchaseHistoryList) {
            Long productId = list.getProductId();
            Optional<Product> result = productRepository.findById(productId);
            Product product = result.get();
            Detail productDetail = Detail.builder().build().toDto(product);
            productDetailList.add(productDetail);
        }


        return productDetailList;
    }

    @Override
    public List<Detail> getMySalesHistory(String userEmail) {
        List<SalesHistory> salesHistoryList = salesHistoryRepository.findByUserEmail(userEmail);
        List<Detail> productDetailList = new ArrayList<Detail>();

        for(SalesHistory list : salesHistoryList) {
            Long productId = list.getProductId();
            Optional<Product> result = productRepository.findById(productId);
            Product product = result.get();
            Detail productDetail = Detail.builder().build().toDto(product);
            productDetailList.add(productDetail);
        }

        return productDetailList;

    }
}
