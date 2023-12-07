package com.lambsroad.trendella.modules.member.application.port

import com.lambsroad.trendella.modules.member.domain.vo.Gender
import com.lambsroad.trendella.modules.member.domain.vo.Grades
import com.lambsroad.trendella.modules.member.domain.vo.Roles

data class MemberRegisterAccountPort(
    val username: String,
    val email: String,
    val password: String,
    val phone: String,
    val gender: Gender,
    val grade: Grades,
    val roles: Roles
)
