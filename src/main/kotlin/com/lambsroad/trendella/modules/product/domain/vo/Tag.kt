package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.Comment


@Entity
class Tag(
    name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(length = 10, nullable = false)
    @Comment("태그 이름")
    var name: String = name
        protected set

    @ManyToMany(mappedBy = "hashtags")
    var product: MutableList<Product> = ArrayList()
        protected set
}
