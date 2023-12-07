package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

//TODO: 상품 마다 가이드가 다름.
//TODO: 추상화 예정
@Entity
@Comment("상품 가이드")
class Guidance(
    fit: String,
    touchness: String,
    flexibility: String,
    seeThrough: String,
    thickness: String,
    season: String,
    product: Product
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column
    @Comment("")
    var fit: String = fit
        protected set

    @Column
    @Comment("")
    var touchness: String = touchness
        protected set

    @Column
    @Comment("")
    var flexibility: String = flexibility
        protected set

    @Column
    @Comment("")
    var seeThrough: String = seeThrough
        protected set

    @Column
    @Comment("")
    var thickness: String = thickness
        protected set

    @Column
    @Comment("")
    var season: String = season
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @OneToOne(mappedBy = "guidance")
    var product: Product? = product
        protected set
}
