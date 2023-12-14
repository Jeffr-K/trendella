package com.lambsroad.trendella.modules.cart.application.service

import com.lambsroad.trendella.modules.cart.application.port.CartAppendPort
import com.lambsroad.trendella.modules.cart.application.port.CartExcludePort
import org.springframework.stereotype.Service

@Service
class CartService {

    fun addProductToCart(port: CartAppendPort) {}

    fun excludeProductFromCart(port: CartExcludePort) {}
}
