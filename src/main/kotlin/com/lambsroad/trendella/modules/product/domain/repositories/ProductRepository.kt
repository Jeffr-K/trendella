package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.infrastructure.database.support.ProductRepositorySupport
import com.lambsroad.trendella.modules.product.domain.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>, ProductRepositorySupport {}
