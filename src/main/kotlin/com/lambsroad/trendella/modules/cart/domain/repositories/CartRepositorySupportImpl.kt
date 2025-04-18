package com.lambsroad.trendella.modules.cart.domain.repositories

import com.lambsroad.trendella.modules.cart.domain.entities.Cart
import com.lambsroad.trendella.modules.cart.domain.entities.QCart
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class CartRepositorySupportImpl(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(Cart::class.java),
    CartRepositorySupport {

    override fun retrieveCart(cartId: Long): Cart? {
        return queryFactory
            .selectFrom(QCart.cart)
            .where(QCart.cart.id.eq(cartId))
            .fetchOne()
    }
}
