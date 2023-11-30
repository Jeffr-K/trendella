package com.lambsroad.trendella.modules.review.domain.entity

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.annotations.Comment

@Entity
class Review(
    @Column(name = "star")
    @Comment("별점")
    val star: Int,

    @Column(name = "likes")
    @Comment("좋아요")
    val likes: Int,

) : AbstractModelFields() {

}
