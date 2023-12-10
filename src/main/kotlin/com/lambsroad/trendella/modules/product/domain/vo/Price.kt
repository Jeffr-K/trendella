package com.lambsroad.trendella.modules.product.domain.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.annotations.Comment

@Embeddable
class Price(
    originPrice: Long,
    discountPrice: Long
) {
    @Column
    @Comment("상품 본 가격")
    var originPrice: Long = originPrice
        protected set

    @Column
    @Comment("상품 할인 가격")
    var discountPrice: Long = discountPrice
        protected set
}
