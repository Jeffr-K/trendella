package com.lambsroad.trendella.modules.product.domain.vo

import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Comment("상품사진")
class Picture(
    url: String,
    usages: String,
    representative: Boolean,
    sequence: Int,
    product: Product?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(length = 255, nullable = false)
    @Comment("이미지 사용처")
    var usages: String = usages
        protected set

    @Column(length = 255, nullable = false)
    @Comment("이미지 저장 경로")
    var url: String = url
        protected set

    @Column(nullable = false)
    @Comment("대표 이미지 여부")
    var representative: Boolean = representative
        protected set

    @Column(length = 255, nullable = false)
    @Comment("이미지 순서")
    var sequence: Int = sequence
        protected set

    @CreationTimestamp
    @Comment("등록일시")
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    @Comment("수정일시")
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var product: Product? = product
        protected set
}
