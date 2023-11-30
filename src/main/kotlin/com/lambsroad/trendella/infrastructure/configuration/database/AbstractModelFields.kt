package com.lambsroad.trendella.infrastructure.configuration.database

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractModelFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
