package com.lambsroad.trendella.modules.brand.application.domain.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.lambsroad.trendella.modules.brand.application.domain.vo.BusinessRegistration
import com.lambsroad.trendella.modules.product.domain.entities.Product
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Brand(
    businessRegistration: BusinessRegistration
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @OneToOne
    var businessRegistration: BusinessRegistration? = businessRegistration
        protected set

    @JsonManagedReference("brandReference")
    @OneToMany(mappedBy = "brand")
    var products: MutableList<Product> = ArrayList()
        protected set
}
