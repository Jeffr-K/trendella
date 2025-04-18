package com.lambsroad.trendella.modules.cart.presentor.controller

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.modules.cart.application.port.CartAppendPort
import com.lambsroad.trendella.modules.cart.application.port.CartExcludePort
import com.lambsroad.trendella.modules.cart.application.service.CartService
import com.lambsroad.trendella.modules.cart.presentor.adapter.CartAppendAdapter
import com.lambsroad.trendella.modules.cart.presentor.adapter.CartExcludeAdapter
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController(
    private val cartService: CartService
) {

    @PostMapping
    fun addToCart(@RequestBody @Valid adapter: CartAppendAdapter): Result<*> {
        this.cartService.addProductToCart(
            CartAppendPort(
                adapter.productId,
                adapter.memberId,
                adapter.quantity
            )
        )

        return Result.success("카트에 상품이 성공적으로 추가 처리되었습니다.", null)
    }

    @DeleteMapping
    fun removeFromCart(@RequestBody @Valid adapter: CartExcludeAdapter): Result<*> {
        this.cartService.excludeProductFromCart(
            CartExcludePort(
                adapter.cartId,
                adapter.productId,
                adapter.memberId,
            )
        )

        return Result.success("카트에 상품이 성공적으로 제외 처리되었습니다.", null)
    }

   // TODO: 기능 도출: 나의 장바구니를 확인할 수 있다
    @GetMapping("/list/{memberId}/{productId}")
    fun retrieveMyCart(
        @PathVariable memberId: Long,
        @PathVariable productId: Long
    ): Result<*> {
        val cart = this.cartService.retrieveAll()
        return Result.success("성공적으로 카트를 조회하였습니다.", cart)
    }

    fun clear() {}



    // TODO: 장바구니 상품 수량 변경
    fun updateProductQuantity() {}

    // TODO: 장바구니 상품 옵션 변경
    fun updateProductOption() {}



}
