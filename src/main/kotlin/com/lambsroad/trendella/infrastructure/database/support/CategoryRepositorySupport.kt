package com.lambsroad.trendella.infrastructure.database.support

import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.infrastructure.database.adapters.CategoriesSearchAllAdapter

interface CategoryRepositorySupport {
    fun getCategory(categoryId: Long?): Category?
    fun getCategories(): MutableList<CategoriesSearchAllAdapter>
    fun editCategory(categoryId: Long, name: String)
}
