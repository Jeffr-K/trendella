package com.lambsroad.trendella.infrastructure.database.support

import com.lambsroad.trendella.infrastructure.database.adapters.ProductDetailRetrieveAdapter
import com.lambsroad.trendella.modules.product.domain.entities.Product
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

interface ProductRepositorySupport {
    fun retrieveProductProjection(productId: Long): ProductDetailRetrieveAdapter?
    fun retrieveProducts(pageable: Pageable): PageImpl<Product>
    fun retrieveProduct(productId: Long): Product?
}
