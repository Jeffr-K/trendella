package com.lambsroad.trendella.modules.member.application.service

import com.lambsroad.trendella.modules.member.domain.entities.Member
import com.lambsroad.trendella.modules.member.domain.repositories.MemberRepository
import com.lambsroad.trendella.modules.member.domain.vo.Gender
import com.lambsroad.trendella.modules.member.domain.vo.Grades
import com.lambsroad.trendella.modules.member.domain.vo.Roles
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun registerUser() {
        val newMember = Member(
            "윤정기",
            "wjdrlrkdl3@gmail.com",
            "test",
            "010-3123-2244",
            Gender.MALE,
            Grades.BRONZE,
            Roles.MEMBER
        )

        this.memberRepository.save(newMember)
    }

    fun getUser(id: Long): Member? {
        println("id??: $id")
        return this.memberRepository.findMemberById(id)
    }
}
