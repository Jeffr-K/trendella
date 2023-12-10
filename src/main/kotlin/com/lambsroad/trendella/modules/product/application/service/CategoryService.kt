package com.lambsroad.trendella.modules.product.application.service

import com.lambsroad.trendella.modules.product.application.port.CategoryDeletePort
import com.lambsroad.trendella.modules.product.application.port.CategoryEditPort
import com.lambsroad.trendella.modules.product.application.port.CategoryRegisterPort
import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.modules.product.domain.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun registerCategory(port: CategoryRegisterPort): Boolean {
        return true
    }

    fun deleteCategory(port: CategoryDeletePort): Boolean {
        return true
    }

    fun editCategory(port: CategoryEditPort): Boolean {
        return true
    }

    fun getCategory(): Category? {
        return this.categoryRepository.getCategory()
    }

    fun getCategories(): MutableList<Category?> {
        return this.categoryRepository.getCategories()
    }

}
