package com.esctb.restapiserver.domain.product.entity;

public enum ProductStatus {
    RESERVED, // 예약 중인 상품
    SOLD, // 판매 완료된 상품
    DECLARED, // 신고 상품
    SALE // 판매 중인 상품
}
