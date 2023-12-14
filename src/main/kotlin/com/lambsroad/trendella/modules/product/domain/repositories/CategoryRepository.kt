package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.infrastructure.database.support.CategoryRepositorySupport
import com.lambsroad.trendella.modules.product.domain.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long>, CategoryRepositorySupport {}
