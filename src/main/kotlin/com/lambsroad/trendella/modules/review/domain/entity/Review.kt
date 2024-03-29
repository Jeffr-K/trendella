package com.lambsroad.trendella.modules.review.domain.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "star")
    @Comment("별점")
    val star: Int,

    @Column(name = "likes")
    @Comment("좋아요")
    val likes: Int,

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @JsonManagedReference("reviewReference")
    @OneToMany(mappedBy = "review")
    var replies: MutableList<Reply> = ArrayList()
) {}
