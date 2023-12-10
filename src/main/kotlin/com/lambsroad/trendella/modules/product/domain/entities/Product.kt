package com.lambsroad.trendella.modules.product.domain.entities

import com.lambsroad.trendella.modules.product.domain.vo.*
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Product (
    title: String,
    price: Price,
    url: String,
    hashtag: Tag,
    brand: Brand,
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

    @Column(nullable = false)
    var url: String = url
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @ManyToOne(fetch = FetchType.LAZY)
    var category: Category? = category
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
    var options: MutableList<Options> = ArrayList()
        protected set

    @OneToMany(mappedBy = "product")
    var pictures: MutableList<Picture> = ArrayList()
        protected set

    @ManyToMany
    @JoinTable(name = "HashTag",
        joinColumns = [JoinColumn(name = "productId")],
        inverseJoinColumns = [JoinColumn(name = "tagId")])
    var hashtags: MutableList<Tag> = ArrayList()
        protected set
}
