package com.lambsroad.trendella.modules.product.domain.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.annotations.Comment

@Embeddable
class Price(
    @Column(name = "originPrice")
    @Comment("상품 본 가격")
    val originPrice: Long,

    @Column(name = "originPrice")
    @Comment("상품 할인 가격")
    val discountPrice: Long
) {}
