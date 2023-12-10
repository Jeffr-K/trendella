package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull

data class CategorySearchAdapter(
    @field:NotNull
    val categoryId: Long
)
