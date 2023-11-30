package com.lambsroad.trendella.modules.member.domain.vo

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Address(
    @Column(name = "city")
    val city: String,

    @Column(name = "country")
    val country: String,

    @Column(name = "county")
    val county: String,

    @Column(name = "street")
    val street: String,

    @Column(name = "zipcode")
    val zipcode: String

) : AbstractModelFields() {}
