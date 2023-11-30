package com.lambsroad.trendella.modules.member.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

@Entity
class BusinessRegistration(
    @Column(name = "businessNumber")
    @Comment("사업자 번호")
    val businessNumber: Int,

    @Column(name = "contactNumber")
    @Comment("사업자 연락처")
    val contactNumber: String,

    @Column(name = "businessEmail")
    @Comment("사업자 이메일")
    val businessEmail: String,

    @Column(name = "returnAddress")
    @Comment("반송지 주소")
    val returnAddress: String,

    @Column(name = "businessLocation")
    @Comment("영업 소재지")
    val businessLocation: String


) : AbstractModelFields() {}
