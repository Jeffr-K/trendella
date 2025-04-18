package com.lambsroad.trendella.modules.cart.domain.vo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set
}
