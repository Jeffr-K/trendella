package com.lambsroad.trendella.modules.cart.presentor.adapter

import jakarta.validation.constraints.NotNull

data class CartAppendAdapter(
    @field:NotNull(message = "상품 번호를 입력해주세요.")
    val productId: Long,

    @field:NotNull(message = "회원 번호를 입력해주세요.")
    val memberId: Long,

    @field:NotNull(message = "수량을 입력해주세요.")
    val quantity: Int
)
