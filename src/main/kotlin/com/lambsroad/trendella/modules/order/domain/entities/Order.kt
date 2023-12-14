package com.lambsroad.trendella.modules.order.domain.entities

import com.lambsroad.trendella.modules.order.domain.vo.OrderStatus
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Orders(
    orderTrackingNumber: Int,
    orderStatus: OrderStatus,
    payoff: Boolean,
    totalProductAmount: Long,
    totalAmount: Long,
    shippingFee: Long,
    destination: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column
    @Comment("주문번호")
    var orderTrackingNumber: Int = orderTrackingNumber
        protected set

    @Column
    @Enumerated(EnumType.STRING)
    @Comment("주문상태")
    var orderStatus: OrderStatus = orderStatus
        protected set

    @Column
    @Comment("결제상태")
    var payoff: Boolean = payoff
        protected set

    @Column
    @Comment("총 상품금액")
    var totalProductAmount: Long = totalProductAmount
        protected set

    @Column
    @Comment("총 주문금액")
    var totalAmount: Long = totalAmount
        protected set

    @Column
    @Comment("배송료")
    var shippingFee: Long = shippingFee
        protected set

    @Column
    @Comment("도착지")
    var destination: String = destination
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    // user
    // 상품
}

