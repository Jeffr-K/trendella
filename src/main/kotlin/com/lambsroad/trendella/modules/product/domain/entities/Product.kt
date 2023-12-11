package com.lambsroad.trendella.modules.product.domain.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @JsonBackReference("categoryReference")
    @ManyToOne(fetch = FetchType.LAZY)
    var category: Category = category
        protected set

    @JsonBackReference("brandReference")
    @ManyToOne(fetch = FetchType.LAZY)
    var brand: Brand? = brand
        protected set

    @JsonBackReference("guidanceReference")
    @OneToOne(fetch = FetchType.LAZY)
    var guidance: Guidance? = guidance
        protected set

    @JsonBackReference("informationReference")
    @OneToOne(fetch = FetchType.LAZY)
    var information: Information? = information
        protected set

    @JsonManagedReference("optionsReference")
    @OneToMany(mappedBy = "product")
    var options: MutableList<Options> = options
        protected set

    @JsonManagedReference("picturesReference")
    @OneToMany(mappedBy = "product")
    var pictures: MutableList<Picture> = pictures
        protected set


    @ManyToMany
    @JsonIgnoreProperties("product") // TODO: 희림님께 공유 (양방향 순환 참조 방어용 코드, @JsonIgnore 와 @JsonManagedReference 공유)
    @JoinTable(name = "HashTag",
        joinColumns = [JoinColumn(name = "productId")],
        inverseJoinColumns = [JoinColumn(name = "tagId")])
    var hashtags: MutableList<Tag> = hashtag
        protected set
}
