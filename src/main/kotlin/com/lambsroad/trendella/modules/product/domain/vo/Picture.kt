package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

@Entity
class Picture(
    @Column(name = "usages")
    @Comment("이미지 사용처")
    val usages: String,

    @Column(name = "url")
    @Comment("이미지 저장 경로")
    val url: String,

    @Column(name = "representative")
    @Comment("대표 이미지 여부")
    val representative: Boolean,

    @Column(name = "sequence")
    @Comment("이미지 순서")
    val sequence: Int
) : AbstractModelFields() {}
