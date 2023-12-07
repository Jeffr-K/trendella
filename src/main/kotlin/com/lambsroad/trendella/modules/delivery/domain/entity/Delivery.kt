package com.lambsroad.trendella.modules.delivery.domain.entity

import com.lambsroad.trendella.modules.delivery.domain.vo.DeliveryStatus
import jakarta.persistence.*
import org.hibernate.annotations.Comment

//TODO: System Design: https://tracker.delivery/docs/try
@Entity
class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "trackingNumber")
    @Comment("운송장 번호")
    val trackingNumber: Long,

    @Column(name = "deliveryProvider")
    @Comment("배송 업체")
    val deliveryProvider: String,

    @Column(name = "deliveryStatus")
    @Enumerated(EnumType.STRING)
    @Comment("배송 상태")
    val deliveryStatus: DeliveryStatus = DeliveryStatus.DELIVERY_BEFORE,

    @Column(name = "waybill")
    @Comment("운송장")
    val waybill: String

    // 주문 엔티티

) {}
