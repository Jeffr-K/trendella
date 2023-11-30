package com.lambsroad.trendella.modules.order.domain.vo

enum class OrderStatus(status: String) {
    BEFORE("주문전"),
    PENDING("주문 진행중"),
    CANCELED("주문 취소"),
    COMPLETED("주문 완료")
}
