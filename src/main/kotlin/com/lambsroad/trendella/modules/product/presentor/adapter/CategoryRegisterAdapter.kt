package com.lambsroad.trendella.modules.product.presentor.adapter

import jakarta.validation.constraints.NotNull

data class CategoryRegisterAdapter(
    @field:NotNull
    val name: String
)
