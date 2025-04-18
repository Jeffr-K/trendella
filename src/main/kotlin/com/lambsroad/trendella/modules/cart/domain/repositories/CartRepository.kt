package com.lambsroad.trendella.modules.cart.domain.repositories

import com.lambsroad.trendella.modules.cart.domain.entities.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Long>, CartRepositorySupport {}
