package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.entities.Product
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

interface ProductRepositorySupport {
    fun retrieveProduct(productId: Long): Product?
    fun retrieveProducts(pageable: Pageable): PageImpl<Product>
}
