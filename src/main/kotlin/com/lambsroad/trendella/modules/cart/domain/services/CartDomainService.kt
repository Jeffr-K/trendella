package com.lambsroad.trendella.modules.cart.domain.services

import org.springframework.stereotype.Service

@Service
class CartDomainService {

    // TODO: 기능 도출: 장바구니에 담긴 상품에 쿠폰을 적용할 수 있다
    fun applyCoupon() {}

    // TODO: 기능 도출: 장바구니에 담긴 상품에 적립금을 적용할 수 있다
    fun applyPoint() {}

    // TODO: 기능 도출: 구매 대기중인 장바구니의 상품들이 일주일이 지나면 장바구니가 초기화될 수 있다
    // TODO: 기능 도출: 장바구니가 초기화되면 장바구니 안에 존재하는 상품들의 수량을 하나 더할 수 있다
    fun clearCart() {}
}
