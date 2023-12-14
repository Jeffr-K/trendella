package com.lambsroad.trendella.modules.review.domain.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Reply(
    content: String,
    depth: Int,
    parent: Reply?,
    review: Review
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0

    @Column
    @Comment("내용")
    var content: String = content
        protected set

    @Column()
    @Comment("댓글 계층")
    var depth: Int = depth
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    var parent: Reply? = parent
        protected set

    @JsonIgnore
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator::class,
        property = "id"
    )
    var children: MutableList<Reply> = ArrayList()
        protected set

    @JsonBackReference("reviewReference")
    @ManyToOne(fetch = FetchType.LAZY)
    var review: Review = review
        protected set
}
