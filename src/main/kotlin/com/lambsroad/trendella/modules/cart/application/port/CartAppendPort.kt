package com.lambsroad.trendella.modules.cart.application.port

data class CartAppendPort(
    val productId: Long,
    val memberId: Long,
    val quantity: Int
)
