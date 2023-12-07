package com.lambsroad.trendella.modules.member.presentor.adapter

import com.lambsroad.trendella.modules.member.domain.vo.Gender
import com.lambsroad.trendella.modules.member.domain.vo.Grades
import com.lambsroad.trendella.modules.member.domain.vo.Roles
import jakarta.validation.constraints.NotNull

data class MemberRegisterAdapter(
    @field:NotNull(message = "이름은 필수 입력값 입니다.")
    val username: String,

    @field:NotNull(message = "이메일은 필수 입력값 입니다.")
    val email: String,

    @field:NotNull(message = "비밀번호는 필수 입력값 입니다.")
    val password: String,

    @field:NotNull(message = "휴대폰 번호는 필수 입력값 입니다.")
    val phone: String,

    @field:NotNull(message = "성별은 필수 입력값 입니다.")
    val gender: Gender,

    @field:NotNull(message = "등급은 필수 입력값 입니다.")
    val grades: Grades,

    @field:NotNull(message = "권한은 필수 입력값 입니다.")
    val roles: Roles
)
