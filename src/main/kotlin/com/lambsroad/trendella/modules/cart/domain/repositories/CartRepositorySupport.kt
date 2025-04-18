package com.lambsroad.trendella.modules.cart.domain.repositories

import com.lambsroad.trendella.modules.cart.domain.entities.Cart

interface CartRepositorySupport {
    fun retrieveCart(cartId: Long): Cart?
    fun retrieveAllItemsInMyCart(): List<Cart>
}
