package com.lambsroad.trendella.modules.cart.domain.entities

import com.lambsroad.trendella.modules.member.domain.entities.Member
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Cart(
    member: Member
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @OneToOne
    var member: Member = member
        protected set

    @OneToMany(mappedBy = "cart")
    var snapshots: MutableList<Snapshot> = ArrayList()
        protected set
}
