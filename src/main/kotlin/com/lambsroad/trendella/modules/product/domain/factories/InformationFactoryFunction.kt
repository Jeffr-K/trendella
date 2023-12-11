package com.lambsroad.trendella.modules.product.domain.factories

import com.lambsroad.trendella.modules.product.domain.vo.Information

fun Information.Companion.of(information: Information): Information {
    return Information(
        material = information.material,
        color = information.color,
        size = information.size,
        createdCompany = information.createdCompany,
        createdNation = information.createdNation,
        cleaningMethod = information.cleaningMethod,
        producedAt = information.producedAt,
        warning = information.warning,
        ensureCondition = information.ensureCondition,
        contact = information.contact,
        product = information.product
    )
}
