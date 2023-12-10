package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull

data class CategoryEditAdapter(
    @field:NotNull(message = "")
    val categoryId: Long,

    @field:NotNull(message = "")
    val name: String
)
