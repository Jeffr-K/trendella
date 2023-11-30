package com.lambsroad.trendella.modules.product.presentor.adapter

data class ProductsQueryAdapter(
    val id: Long,
    val provider: String,
    val title: String,
    val price: Int,
    val url: String
) {}

