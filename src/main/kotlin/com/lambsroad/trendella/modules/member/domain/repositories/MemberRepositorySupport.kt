package com.lambsroad.trendella.modules.member.domain.repositories

import com.lambsroad.trendella.modules.member.domain.entities.Member

interface MemberRepositorySupport {
    fun findMemberById(memberId: Long?): Member?
}
