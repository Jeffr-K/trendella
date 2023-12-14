package com.lambsroad.trendella.infrastructure.database.adapters

import com.querydsl.core.annotations.QueryProjection

data class OptionsRetrieverAdapter @QueryProjection constructor(
    val type: String,
    val name: String,
    val price: Int,
)
