package com.lambsroad.trendella.modules.product.domain.entities

import com.lambsroad.trendella.infrastructure.configuration.database.AbstractModelFields
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Category(
    @Column(name = "name")
    @Comment("카테고리 이름")
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    val parent: Category?,

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    val children: MutableList<Category> = ArrayList()

) : AbstractModelFields() {}
