package com.lambsroad.trendella.modules.member.domain.entities

import com.lambsroad.trendella.modules.member.domain.vo.Gender
import com.lambsroad.trendella.modules.member.domain.vo.Grades
import com.lambsroad.trendella.modules.member.domain.vo.Roles
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
class Member(
    username: String,
    email: String,
    password: String,
    phone: String,
    gender: Gender,
    grade: Grades,
    roles: Roles
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(length = 20, nullable = false)
    var username: String = username
        protected set

    @Column(length = 100, nullable = false, unique = true)
    var email: String = email
        protected set

    @Column(length = 255, nullable = false)
    var password: String = password
        protected set

    @Column(length = 20, nullable = false)
    var phone: String = phone
        protected set

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    var gender: Gender = gender
        protected set

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    var grade: Grades = grade
        protected set

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    var roles: Roles = roles
        protected set

    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

}
