package com.lambsroad.trendella.infrastructure.database.adapters

import com.querydsl.core.annotations.QueryProjection

data class PicturesRetrieverAdapter @QueryProjection constructor(
    val id: Long,
    val url: String,
    val usages: String,
    val representative: Boolean,
    val sequence: Int,
)
