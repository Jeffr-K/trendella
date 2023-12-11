package com.lambsroad.trendella.modules.product.domain.repositories.adapters

import com.lambsroad.trendella.modules.brand.application.domain.entities.Brand
import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.modules.product.domain.entities.Product
import com.lambsroad.trendella.modules.product.domain.vo.*
import java.time.LocalDateTime


data class ProductDetailRetrieveAdapter(
    val id: Long?,
    val title: String,
    val price: Price,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val category: Category,
    val brand: Brand?,
    val guidance: Guidance?,
    val information: Information?,
    val options: List<Options>,
    val pictures: List<Picture>,
    val hashtags: MutableList<HashTagRetrieveAdapter?>
) {
    companion object {
        fun from(product: Product): ProductDetailRetrieveAdapter {
            return ProductDetailRetrieveAdapter(
                id = product.id,
                title = product.title,
                price = product.price,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt,
                category = product.category,
                brand = product.brand,
                guidance = product.guidance,
                information = product.information,
                options = product.options.toList(),  // LAZY 로딩을 위해 toList() 사용
                pictures = product.pictures.toList(),  // LAZY 로딩을 위해 toList() 사용
                hashtags = product.hashtags.map { HashTagRetrieveAdapter.from(it) }.toMutableList()
            )
        }
    }
}

