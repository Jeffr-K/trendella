package com.lambsroad.trendella.modules.member.domain.vo

import com.lambsroad.trendella.modules.product.domain.entities.Brand
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class BusinessRegistration(
    businessNumber: Int,
    contactNumber: String,
    businessEmail: String,
    returnAddress: String,
    businessLocation: String,
    businessRegisteredAt: LocalDateTime,
    brand: Brand
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(nullable = false)
    @Comment("사업자 번호")
    var businessNumber: Int = businessNumber
        protected set

    @Column(length = 100, nullable = false)
    @Comment("사업자 연락처")
    var contactNumber: String = contactNumber
        protected set

    @Column(length = 100, nullable = false)
    @Comment("사업자 이메일")
    var businessEmail: String = businessEmail
        protected set

    @Column
    @Comment("사업자 등록 일시")
    var businessRegisteredAt: LocalDateTime = businessRegisteredAt
        protected set

    @Column(length = 100, nullable = false)
    @Comment("반송지 주소")
    var returnAddress: String = returnAddress
        protected set

    @Column(length = 100, nullable = false)
    @Comment("영업 소재지")
    var businessLocation: String = businessLocation
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @OneToOne(mappedBy = "businessRegistration")
    var brand: Brand? = brand
        protected set
}
