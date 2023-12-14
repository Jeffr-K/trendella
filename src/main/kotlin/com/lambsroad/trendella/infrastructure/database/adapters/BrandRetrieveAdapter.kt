package com.lambsroad.trendella.infrastructure.database.adapters

import com.lambsroad.trendella.modules.brand.application.domain.vo.BusinessRegistration
import com.querydsl.core.annotations.QueryProjection

data class BrandRetrieveAdapter @QueryProjection constructor(
    val businessRegistration: BusinessRegistration
)
