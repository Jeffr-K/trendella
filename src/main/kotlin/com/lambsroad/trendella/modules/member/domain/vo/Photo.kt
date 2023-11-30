package com.lambsroad.trendella.modules.member.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

@Entity
class Photo(
    @Column(name = "usages")
    @Comment("이미지 사용처")
    val usages: String,

    @Column(name = "url")
    @Comment("이미지 저장 경로")
    val url: String,

) : AbstractModelFields() {}
