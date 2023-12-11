package com.lambsroad.trendella.modules.product.domain.repositories.adapters

import com.lambsroad.trendella.modules.product.domain.entities.Category
import java.time.LocalDateTime

data class CategoriesSearchAllAdapter(
    val id: Long?,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val children: List<CategoriesSearchAllAdapter>,
) {
    constructor(category: Category) : this (
        id = category.id,
        name = category.name,
        createdAt = category.createdAt,
        updatedAt = category.updatedAt,
        children = category.children.map { CategoriesSearchAllAdapter(it) },
    )
}
