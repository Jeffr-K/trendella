package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
class Information(
    @Column(name = "material")
    @Comment("제품소재")
    val material: String,

    @Column(name = "color")
    @Comment("색상")
    val color: String,

    @Column(name = "size")
    @Comment("치수")
    val size: String,

    @Column(name = "createdCompany")
    @Comment("제조사")
    val createdCompany: String,

    @Column(name = "createdNation")
    @Comment("제조국")
    val createdNation: String,

    @Column(name = "cleaningMethod")
    @Comment("세탁 방법")
    val cleaningMethod: String,

    @Column(name = "producedAt")
    @Comment("제조 년월")
    val producedAt: LocalDateTime,

    @Column(name = "warning")
    @Comment("취급시 주의사항")
    val warning: String,

    @Column(name = "ensureCondition")
    @Comment("품질 보증 기준")
    val ensureCondition: String,

    @Column(name = "contact")
    @Comment("A/S Contact")
    val contact: String,

    ) : AbstractModelFields() {
}
