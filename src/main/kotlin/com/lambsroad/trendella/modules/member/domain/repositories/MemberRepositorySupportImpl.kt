package com.lambsroad.trendella.modules.member.domain.repositories

import com.lambsroad.trendella.modules.member.domain.entities.Member
import com.lambsroad.trendella.modules.member.domain.entities.QMember
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository


@Repository
class MemberRepositorySupportImpl(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(Member::class.java),
    MemberRepositorySupport {

    override fun findMemberById(memberId: Long?): Member? {
        return queryFactory
            .selectFrom(QMember.member)
            .where(QMember.member.id.eq(memberId))
            .fetchOne()
    }

    override fun findMemberByEmail(email: String): Member? {
        return queryFactory
            .selectFrom(QMember.member)
            .where(QMember.member.email.eq(email))
            .fetchOne()
    }

    @Transactional
    override fun deleteMemberAccount(member: Member) {
        queryFactory
            .delete(QMember.member)
            .where(QMember.member.id.eq(member.id))
            .execute()
    }

    override fun getMemberProfile(memberId: Long): Member? {
        return queryFactory
            .selectFrom(QMember.member)
            .where(QMember.member.id.eq(memberId))
            .fetchOne()
    }

}
