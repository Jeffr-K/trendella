package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
class Information(
    material: String,
    color: String,
    size: String,
    createdCompany: String,
    createdNation: String,
    cleaningMethod: String,
    producedAt: Date,
    warning: String,
    ensureCondition: String,
    contact: String,
    product: Product?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(length = 20, nullable = false)
    @Comment("제품소재")
    var material: String = material
        protected set

    @Column(length = 20, nullable = false)
    @Comment("색상")
    var color: String = color
        protected set

    @Column(length = 20, nullable = false)
    @Comment("치수")
    var size: String = size
        protected set

    @Column(length = 20, nullable = false)
    @Comment("제조사")
    var createdCompany: String = createdCompany
        protected set


    @Column(length = 20, nullable = false)
    @Comment("제조국")
    var createdNation: String = createdNation
        protected set

    @Column(length = 20, nullable = false)
    @Comment("세탁 방법")
    var cleaningMethod: String = cleaningMethod
        protected set

    @Column(length = 20, nullable = false)
    @Comment("제조 년월")
    var producedAt: Date = producedAt
        protected set

    @Column(length = 20, nullable = false)
    @Comment("취급시 주의사항")
    var warning: String =  warning
        protected set

    @Column(length = 20, nullable = false)
    @Comment("품질 보증 기준")
    var ensureCondition: String =  ensureCondition
        protected set

    @Column(length = 20, nullable = false)
    @Comment("A/S Contact")
    var contact: String = contact
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @OneToOne(mappedBy = "information")
    var product: Product? = product
        protected set

    companion object {}

}
