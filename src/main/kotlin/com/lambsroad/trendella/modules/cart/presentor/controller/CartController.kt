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
    fun add(@RequestBody @Valid adapter: CartAppendAdapter): Result<*> {
        this.cartService.addProductToCart(CartAppendPort(adapter.productId))
        return Result.success("카트에 상품이 성공적으로 추가 처리되었습니다.", null)
    }

    @DeleteMapping
    fun remove(@RequestBody @Valid adapter: CartExcludeAdapter): Result<*> {
        this.cartService.excludeProductFromCart(CartExcludePort(adapter.productId))
        return Result.success("카트에 상품이 성공적으로 제외 처리되었습니다.", null)
    }

    // TODO: 기능 도출: 나의 장바구니를 확인할 수 있다
    @GetMapping("/list")
    fun retrieveAll() {}

}
