package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositorySupportImpl(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(Category::class.java),
    CategoryRepositorySupport {
    override fun getCategory(): Category? {
        TODO("Not yet implemented")
    }

    override fun getCategories(): MutableList<Category?> {
        TODO("Not yet implemented")
    }
}
