package com.lambsroad.trendella.modules.review.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Reply(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "content")
    @Comment("내용")
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    val parent: Reply?,

    @Column(name = "depth")
    @Comment("댓글 계층")
    val depth: Int,

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    val children: MutableList<Reply> = ArrayList(),

) {}
