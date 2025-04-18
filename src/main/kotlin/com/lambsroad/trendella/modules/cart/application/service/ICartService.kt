package com.lambsroad.trendella.modules.cart.application.service

import com.lambsroad.trendella.modules.cart.application.port.CartAppendPort

interface ICartService {
    fun addProductToCart(port: CartAppendPort)
}
