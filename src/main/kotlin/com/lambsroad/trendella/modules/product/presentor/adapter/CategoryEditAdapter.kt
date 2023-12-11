package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull

data class CategoryEditAdapter(
    @field:NotNull(message = "카테고리 아이디는 필수 입력 값 입니다.")
    val categoryId: Long,

    @field:NotNull(message = "변경할 카테고리 이름은 필수 입력 값 입니다.")
    val name: String
)
