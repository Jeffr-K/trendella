package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

@Entity
class Description(
    @Column(name = "url")
    @Comment("상품 설명 이미지 템플릿 저장 경로")
    val url: String

) : AbstractModelFields() {}
