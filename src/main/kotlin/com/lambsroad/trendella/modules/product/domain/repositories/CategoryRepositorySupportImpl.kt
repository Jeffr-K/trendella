package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.modules.product.domain.entities.QCategory
import com.lambsroad.trendella.modules.product.domain.repositories.adapters.CategoriesSearchAllAdapter
import com.lambsroad.trendella.modules.product.domain.repositories.conditions.CategoryDynamicQuery.Companion.categoryIdEq
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositorySupportImpl(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(Category::class.java),
    CategoryRepositorySupport {
    override fun getCategory(categoryId: Long?): Category? {
        return queryFactory
            .selectFrom(QCategory.category)
            .where(categoryIdEq(categoryId))
            .fetchOne()
    }

    override fun getCategories(): MutableList<CategoriesSearchAllAdapter> {
        val rootCategories = queryFactory
            .selectFrom(QCategory.category)
            .where(QCategory.category.parent.isNull)
            .fetch()

        return rootCategories.map { CategoriesSearchAllAdapter(it) }.toMutableList()
    }

    @Transactional
    override fun editCategory(categoryId: Long, name: String) {
        val category = queryFactory
            .selectFrom(QCategory.category)
            .where(QCategory.category.id.eq(categoryId))
            .fetchOne()
                ?: throw NoSuchElementException("아이디로 조회되는 카테고리가 없습니다.: $categoryId")

        queryFactory
            .update(QCategory.category)
            .set(QCategory.category.name, name)
            .set(QCategory.category.parent, category.parent)
            .where(categoryIdEq(categoryId))
            .execute()
    }
}
