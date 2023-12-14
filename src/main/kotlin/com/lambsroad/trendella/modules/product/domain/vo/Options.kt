package com.lambsroad.trendella.modules.product.domain.vo

import com.fasterxml.jackson.annotation.JsonBackReference
import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Options(
    type: String,
    name: String,
    price: Int,
    quantity: Int?,
    product: Product?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(length = 50, nullable = false)
    @Comment("옵션 타입")
    var type: String = type
        protected set

    @Column(length = 50, nullable = false)
    @Comment("옵션 이름")
    var name: String = name
        protected set

    @Column(nullable = false)
    @Comment("옵션 가격")
    var price: Int = price
        protected set

    // TODO: nullable 지워야함
    // TODO: 옵션 별 상품 수량을 상품 등록 시 정확히 입력해줘야 할까?
    // TODO: 옵션 별 상품 수량 변경 API 고민
    @Column(nullable = false)
    @Comment("옵션 가격")
    var quantity: Int? = quantity
        protected set

    @JsonBackReference("optionsReference")
    @ManyToOne(fetch = FetchType.LAZY)
    var product: Product? = product
        protected set
}
