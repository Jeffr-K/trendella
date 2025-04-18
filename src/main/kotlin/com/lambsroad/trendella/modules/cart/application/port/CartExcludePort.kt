package com.lambsroad.trendella.modules.cart.application.port

data class CartExcludePort(
    val cartId: Long,
    val productId: Long,
    val memberId: Long,
)
