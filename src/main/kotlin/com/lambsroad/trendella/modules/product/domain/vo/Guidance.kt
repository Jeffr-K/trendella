package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

//TODO: 상품 마다 가이드가 다름.
//TODO: 추상화 예정
@Entity
class Guidance(
    @Column
    @Comment("")
    val fit: String,

    @Column
    @Comment("")
    val touchness: String,

    @Column
    @Comment("")
    val flexibility: String,

    @Column
    @Comment("")
    val seeThrough: String,

    @Column
    @Comment("")
    val thickness: String,

    @Column
    @Comment("")
    val season: String
) : AbstractModelFields() {}
