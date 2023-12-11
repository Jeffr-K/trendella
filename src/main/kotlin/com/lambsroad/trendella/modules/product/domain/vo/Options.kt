package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Options(
    type: String,
    name: String,
    price: Int,
    product: Product?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(length = 50, nullable = false)
    @Comment("옵션 타입")
    var type: String = type
        protected set

    @Column(length = 50, nullable = false)
    @Comment("옵션 이름")
    var name: String = name
        protected set

    @Column(nullable = false)
    @Comment("옵션 가격")
    var price: Int = price
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var product: Product? = product
        protected set
}
