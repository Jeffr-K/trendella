package com.lambsroad.trendella.modules.product.domain.vo

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Comment("상품정보 제공고시")
class Description(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "url")
    @Comment("상품 설명 이미지 템플릿 저장 경로")
    val url: String
) {}
