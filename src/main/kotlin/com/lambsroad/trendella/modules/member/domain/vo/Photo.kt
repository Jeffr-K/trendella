package com.lambsroad.trendella.modules.member.domain.vo

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Photo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "usages")
    @Comment("이미지 사용처")
    val usages: String,

    @Column(name = "url")
    @Comment("이미지 저장 경로")
    val url: String,

    ) {}
