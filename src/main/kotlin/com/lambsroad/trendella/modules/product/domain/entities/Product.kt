package com.lambsroad.trendella.modules.product.domain.entities

import com.lambsroad.trendella.modules.brand.application.domain.entities.Brand
import com.lambsroad.trendella.modules.product.domain.vo.*
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Product (
    title: String,
    price: Price,
    pictures: MutableList<Picture>,
    hashtag: MutableList<Tag>,
    brand: Brand,
    options: MutableList<Options>,
    category: Category,
    guidance: Guidance,
    information: Information
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @Column(length = 30, nullable = false)
    var title: String = title
        protected set
    @Embedded
    var price: Price = price
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @ManyToOne(fetch = FetchType.LAZY)
    var category: Category = category
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var brand: Brand? = brand
        protected set

    @OneToOne
    var guidance: Guidance? = guidance
        protected set

    @OneToOne
    var information: Information? = information
        protected set

    @OneToMany(mappedBy = "product")
    var options: MutableList<Options> = options
        protected set

    @OneToMany(mappedBy = "product")
    var pictures: MutableList<Picture> = pictures
        protected set

    @ManyToMany
    @JoinTable(name = "HashTag",
        joinColumns = [JoinColumn(name = "productId")],
        inverseJoinColumns = [JoinColumn(name = "tagId")])
    var hashtags: MutableList<Tag> = hashtag
        protected set
}
