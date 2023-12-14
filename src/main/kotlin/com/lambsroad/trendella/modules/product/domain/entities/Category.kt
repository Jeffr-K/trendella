package com.lambsroad.trendella.modules.product.domain.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Category(
    name: String,
    parent: Category?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(length = 10, nullable = false)
    @Comment("카테고리 이름")
    var name: String = name
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
    @JoinColumn(name = "parent")
    var parent: Category? = parent
        protected set

//    @JsonIgnore
    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = [CascadeType.ALL])
    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator::class,
        property = "id"
    )
    var children: MutableList<Category> = ArrayList()
        protected set

    // TODO: 무한 참조 문제를 해결하기 위한 두가지 방법의 Trade off 고민
    // TODO: Jackson 라이브러리 학습
    // @JsonSerialize(contentUsing = ProductSerializer::class)
    @JsonBackReference("categoryReference")
    @OneToMany(mappedBy = "category")
    var products: MutableList<Product> = ArrayList()
        protected set

}
