package com.lambsroad.trendella.modules.product.domain.events.handler

import com.lambsroad.trendella.modules.cart.domain.events.event.CartItemExcludedEvent
import com.lambsroad.trendella.modules.product.domain.services.ProductDomainService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class ProductEventHandler(
    private val productDomainService: ProductDomainService
) {

    @Async
    @EventListener
    fun handleCartItemExcludedEvent(event: CartItemExcludedEvent) {
        this.productDomainService.changeProductQuantity(event.productId)
    }


}
