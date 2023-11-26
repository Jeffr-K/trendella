package com.lambsroad.trendella.modules.member.domain

import jakarta.persistence.*


@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "username", unique = true)
    val username: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String
)
