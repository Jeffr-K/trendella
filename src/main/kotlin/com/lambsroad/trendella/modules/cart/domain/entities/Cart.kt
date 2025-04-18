package com.lambsroad.trendella.modules.cart.domain.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Cart(
    memberId: Long,
    productId: Long,
    quantity: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @Column
    var memberId: Long = memberId
        protected set

    @Column
    var productId: Long = productId
        protected set

    @Column
    var quantity: Int = quantity
        protected set

    companion object {}
}
