package com.lambsroad.trendella.modules.product.domain.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
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
    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator::class,
        property = "id"
    )
    var parent: Category? = parent
        protected set

    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = [CascadeType.ALL])
    var children: MutableList<Category> = ArrayList()
        protected set

    @JsonManagedReference("categoryReference")
    @OneToMany(mappedBy = "category")
    var products: MutableList<Product> = ArrayList()
        protected set

}
