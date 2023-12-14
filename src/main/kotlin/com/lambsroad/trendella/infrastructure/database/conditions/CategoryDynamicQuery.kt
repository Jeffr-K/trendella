package com.lambsroad.trendella.infrastructure.database.conditions

import com.lambsroad.trendella.modules.product.domain.entities.QCategory
import com.querydsl.core.types.dsl.BooleanExpression

class CategoryDynamicQuery {
    companion object {
        fun categoryIdEq(categoryId: Long?): BooleanExpression {
            return categoryId?.let { QCategory.category.id.eq(it) }
                ?: QCategory.category.id.isNull()
        }
    }
}
