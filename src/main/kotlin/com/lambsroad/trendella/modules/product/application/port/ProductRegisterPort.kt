package com.lambsroad.trendella.modules.product.application.port

import com.lambsroad.trendella.modules.product.domain.vo.*

data class ProductRegisterPort(
    val title: String,
    val price: Price,
    val quantity: Int,
    val hashTag: MutableList<Tag>,
    val brandId: Long,
    val options: MutableList<Options>,
    val pictures: MutableList<Picture>,
    val categoryId: Long,
    val guidance: Guidance,
    val information: Information
)
