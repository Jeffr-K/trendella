package com.lambsroad.trendella.modules.member.domain.services

import com.lambsroad.trendella.modules.member.domain.entities.Member
import com.lambsroad.trendella.modules.member.domain.repositories.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberDomainService(
    private val memberRepository: MemberRepository
) {
    fun isAlreadyMemberExist(email: String): Boolean {
        val member = this.memberRepository.findMemberByEmail(email)
        return member != null
    }

    fun getMemberById(id: Long): Member? {
        val member = this.memberRepository.findMemberById(id)
        return member
    }
}
