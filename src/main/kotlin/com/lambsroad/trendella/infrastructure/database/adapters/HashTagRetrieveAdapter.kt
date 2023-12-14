package com.lambsroad.trendella.infrastructure.database.adapters

import com.querydsl.core.annotations.QueryProjection

data class HashTagRetrieveAdapter @QueryProjection constructor(
    val id: Long?,
    val name: String
)
