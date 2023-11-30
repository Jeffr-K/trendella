package com.lambsroad.trendella.modules.product.domain.entities

import com.lambsroad.trendella.modules.product.domain.vo.Tag
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.ArrayList

@Entity
class Product (
    title: String,
    price: Long,
    url: String,
    provider: String,
    hashtag: Tag,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0

    @Column(length = 30, nullable = false)
    var title: String = title
        protected set

    @Column(nullable = false)
    var price: Long = price
        protected set

    @Column(nullable = false)
    var url: String = url
        protected set

    @Column(nullable = false)
    var provider: String = provider
        protected set

    @Embedded
    var tag: Tag = hashtag
        protected set
}
