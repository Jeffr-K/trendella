package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.entities.Category

interface CategoryRepositorySupport {
    fun getCategory(): Category?
    fun getCategories(): MutableList<Category?>
}
