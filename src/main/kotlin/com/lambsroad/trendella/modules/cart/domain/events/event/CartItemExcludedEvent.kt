package com.lambsroad.trendella.modules.cart.domain.events.event

data class CartItemExcludedEvent(
    val cartId: Long,
    val productId: Long,
    val memberId: Long
)
