package com.lambsroad.trendella.modules.member.domain.vo

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "city")
    val city: String,

    @Column(name = "country")
    val country: String,

    @Column(name = "county")
    val county: String,

    @Column(name = "street")
    val street: String,

    @Column(name = "zipcode")
    val zipcode: String,

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()

) {}
