package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

data class CategoryDeleteAdapter(
    @field:NotNull(message = "카테고리 아이디는 필수 입력 값 입니다.")
    @field:PositiveOrZero(message = "부모 카테고리는 양수이어야 합니다.")
    val categoryId: Long
)
