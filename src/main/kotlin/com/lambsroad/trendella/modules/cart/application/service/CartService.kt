package com.lambsroad.trendella.modules.cart.application.service

import com.lambsroad.trendella.modules.cart.application.port.CartAppendPort
import com.lambsroad.trendella.modules.cart.application.port.CartExcludePort
import com.lambsroad.trendella.modules.cart.domain.entities.Cart
import com.lambsroad.trendella.modules.cart.domain.events.event.CartItemExcludedEvent
import com.lambsroad.trendella.modules.cart.domain.repositories.CartRepository
import com.lambsroad.trendella.modules.member.domain.services.MemberDomainService
import com.lambsroad.trendella.modules.product.domain.services.ProductDomainService
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class CartService(
    private val cartRepository: CartRepository,
    private val memberDomainService: MemberDomainService,
    private val productDomainService: ProductDomainService,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Transactional
    fun addProductToCart(port: CartAppendPort) {
        this.memberDomainService.getMemberById(port.memberId)
        this.productDomainService.checkIsPossibleToPurchase(port.productId)

        val cart = Cart(port.memberId, port.productId, port.quantity)
        this.cartRepository.save(cart)
    }

    @Transactional
    fun excludeProductFromCart(port: CartExcludePort): Boolean {
        // pub/sub or observer pattern
        this.applicationEventPublisher.publishEvent(
            CartItemExcludedEvent(
                port.cartId,
                port.productId,
                port.memberId,
            )
        )

        val cart = this.cartRepository.retrieveCart(port.cartId)
            ?: throw IllegalStateException("현재 조회하려는 장바구니가 존재하지 않습니다.")

        this.cartRepository.delete(cart)
        return true
    }

    fun retrieveAll(): List<Cart?> {
        return this.cartRepository.retrieveAllItemsInMyCart()
    }

    fun updateProductQuantity() {}

    fun updateProductOption() {}
}
