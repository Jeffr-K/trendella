package com.lambsroad.trendella.modules.order.domain.entities

import com.lambsroad.trendella.modules.order.domain.vo.OrderStatus
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Orders(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "orderTrackingNumber")
    @Comment("주문번호")
    val orderTrackingNumber: Int,

    @Column(name = "orderStatus")
    @Enumerated(EnumType.STRING)
    @Comment("주문상태")
    val orderStatus: OrderStatus = OrderStatus.BEFORE,

    @Column(name = "payoff")
    @Comment("결제상태")
    val payoff: Boolean = false,

    @Column(name = "totalProductAmount")
    @Comment("총 상품금액")
    val totalProductAmount: Long,

    @Column(name = "totalAmount")
    @Comment("총 주문금액")
    val totalAmount: Long,

    @Column(name = "shippingFee")
    @Comment("배송료")
    val shippingFee: Long,

    @Column(name = "destination")
    @Comment("도착지")
    val destination: String

    // user
    // 상품

) {}
