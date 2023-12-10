package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull

data class CategoriesSearchAdapter(
    @field:NotNull
    val type: String,

    @field:NotNull
    val page: Int,

    @field:NotNull
    val offset: Int
)
