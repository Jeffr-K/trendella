package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.modules.product.domain.repositories.adapters.CategoriesSearchAllAdapter

interface CategoryRepositorySupport {
    fun getCategory(categoryId: Long?): Category?
    fun getCategories(): MutableList<CategoriesSearchAllAdapter>
    fun editCategory(categoryId: Long, name: String)
}
