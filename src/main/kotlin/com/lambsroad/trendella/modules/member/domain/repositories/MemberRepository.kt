package com.lambsroad.trendella.modules.member.domain.repositories

import com.lambsroad.trendella.modules.member.domain.entities.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>, MemberRepositorySupport {}
