package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

@Entity
class Options(
    @Column(name = "type")
    @Comment("옵션 타입")
    val type: String,

    @Column(name = "name")
    @Comment("옵션 이름")
    val name: String,

    @Column(name = "price")
    @Comment("옵션 가격")
    val price: Int = 0

    // 상품 many to one
) : AbstractModelFields() {}
