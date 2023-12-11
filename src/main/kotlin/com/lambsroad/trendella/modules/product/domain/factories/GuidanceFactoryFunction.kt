package com.lambsroad.trendella.modules.product.domain.factories

import com.lambsroad.trendella.modules.product.domain.vo.Guidance

fun Guidance.Companion.of(guidance: Guidance): Guidance {
    return Guidance(
        fit = guidance.fit,
        touchness = guidance.touchness,
        flexibility = guidance.flexibility,
        seeThrough = guidance.seeThrough,
        thickness = guidance.thickness,
        season = guidance.season,
        product = guidance.product
    )
}
