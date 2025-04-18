package com.lambsroad.trendella.modules.cart.domain.vo

import com.lambsroad.trendella.modules.cart.domain.entities.Cart
import jakarta.persistence.*

@Entity
class Item(
    cart: Cart?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var cart: Cart? = cart
        protected set

    companion object {}
}
