package com.lambsroad.trendella.modules.member.domain.entities

import com.lambsroad.trendella.modules.member.domain.vo.Gender
import com.lambsroad.trendella.modules.member.domain.vo.Grades
import com.lambsroad.trendella.modules.member.domain.vo.Roles
import jakarta.persistence.*


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

    @Column(name = "username")
    var username: String = username
        protected set

    @Column(name = "email", unique = true)
    var email: String = email
        protected set

    @Column(name = "password")
    var password: String = password
        protected set

    @Column(name = "phone")
    var phone: String = phone
        protected set

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    var gender: Gender = gender
        protected set

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    var grade: Grades = grade
        protected set

    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    var roles: Roles = roles
        protected set
}
