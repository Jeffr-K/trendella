package com.lambsroad.trendella.modules.review.domain.entity

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Reply(
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

    ) : AbstractModelFields() {}
