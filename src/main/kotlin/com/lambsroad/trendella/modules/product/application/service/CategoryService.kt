package com.lambsroad.trendella.modules.product.application.service

import com.lambsroad.trendella.modules.product.application.port.CategoryDeletePort
import com.lambsroad.trendella.modules.product.application.port.CategoryEditPort
import com.lambsroad.trendella.modules.product.application.port.CategoryRegisterPort
import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.modules.product.domain.repositories.CategoryRepository
import com.lambsroad.trendella.infrastructure.database.adapters.CategoriesSearchAllAdapter
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun registerCategory(port: CategoryRegisterPort): Boolean {
        val category = this.categoryRepository.getCategory(port.parent) // 1
        this.categoryRepository.save(Category(port.name, category))
        return true
    }

    fun deleteCategory(port: CategoryDeletePort): Boolean {
        val category = this.categoryRepository.getCategory(port.categoryId)
        this.categoryRepository.delete(category!!)
        return true
    }

    fun editCategory(port: CategoryEditPort): Boolean {
        this.categoryRepository.editCategory(port.categoryId, port.name)
        return true
    }

    fun getCategories(): MutableList<CategoriesSearchAllAdapter> {
        return this.categoryRepository.getCategories()
    }

}
