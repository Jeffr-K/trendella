package com.lambsroad.trendella.infrastructure.database.adapters

import com.lambsroad.trendella.modules.product.domain.entities.Category
import com.lambsroad.trendella.modules.product.domain.vo.Price
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime


data class ProductDetailRetrieveAdapter @QueryProjection constructor(
    val id: Long?,
    val title: String,
    val price: Price,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val category: Category,
//    val brand: Brand?,
//    val guidance: Guidance,
//    val information: Information?,
//    val options: List<Options>,
//    val pictures: List<Picture>,
//    val hashtags: List<Tag>
)

