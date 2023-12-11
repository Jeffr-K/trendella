package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

data class CategoryRegisterAdapter(
    @field:NotNull(message = "카테고리 이름을 입력해주세요.")
    val name: String,

    @field:PositiveOrZero(message = "부모 카테고리는 양수이어야 합니다.")
    val parent: Long?
)
