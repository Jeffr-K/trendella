package com.lambsroad.trendella.modules.delivery.domain.vo

enum class DeliveryStatus(status: String) {
    DELIVERY_BEFORE("배송전"),
    DELIVERY_PROCESSING("배송 진행중"),
    DELIVERY_COMPLETED("배송 완료")
}
