package com.lambsroad.trendella.modules.cart.domain.events.handler

import org.springframework.stereotype.Service

@Service
class CartDomainEventHandler {

    // TODO: 기능 도출: 한명의 회원이 가입함과 동시에 하나의 장바구니가 만들어질 수 있다
    fun createCart() {}

    // TODO: 기능 도출: 한명의 회원이 탈퇴함과 동시에 하나의 장바구니가 삭제될 수 있다
    fun deleteCart() {}
}
