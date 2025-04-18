package com.lambsroad.trendella.modules.cart.domain.vo

import com.lambsroad.trendella.modules.cart.domain.entities.Cart
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Snapshot(
    cart: Cart,
    quantity: Long,
    price: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column
    @Comment("상품 수량")
    var quantity: Long = quantity
        protected set

    @Column
    @Comment("상품 총 금액")
    var totalPrice: Long = price
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var cart: Cart = cart
        protected set
}
