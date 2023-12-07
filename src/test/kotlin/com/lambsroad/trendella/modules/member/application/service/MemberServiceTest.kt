package com.lambsroad.trendella.modules.member.application.service

import com.lambsroad.trendella.modules.member.application.port.MemberRegisterAccountPort
import com.lambsroad.trendella.modules.member.domain.repositories.MemberRepository
import com.lambsroad.trendella.modules.member.domain.services.MemberDomainService
import com.lambsroad.trendella.modules.member.domain.vo.Gender
import com.lambsroad.trendella.modules.member.domain.vo.Grades
import com.lambsroad.trendella.modules.member.domain.vo.Roles
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class MemberServiceTest : DescribeSpec({

    lateinit var memberRepository: MemberRepository
    lateinit var memberDomainService: MemberDomainService
    lateinit var memberService: MemberService

    beforeTest {
        memberRepository = mockk<MemberRepository>()
        memberDomainService = mockk<MemberDomainService>()

        every { memberRepository.save(any()) } returns mockk()

        memberService = MemberService(memberRepository, memberDomainService)
    }

    describe("registerMemberAccount") {

        it("기존에 가입된 유저가 아니어야 합니다.") {
            // given
            val port = MemberRegisterAccountPort(
                "jeffrey",
                "jeffrey@gmail.com",
                "test",
                "010-3123-2244",
                Gender.MALE,
                Grades.BRONZE,
                Roles.MEMBER
            )

            every { memberDomainService.isAlreadyMemberExist(port.email) } returns false

            // when
            memberService.registerMemberAccount(port)

            // then
            verify(exactly = 1) { memberDomainService.isAlreadyMemberExist(port.email) }
        }
        it("기존 회원이 아니라면, 회원가입이 성공해야 합니다") {

        }
    }

//    describe("getMember") {
//        it("") {}
//    }
//
//    describe("getMembers") {
//        it("") {}
//    }
//
//    describe("updateEmailAccount") {
//        it("") {}
//    }
//
//    describe("updateAccountPassword") {
//        it("") {}
//    }
//
//    describe("dropdownMemberAccount") {
//        it("") {}
//    }
})
//1.3.73-IC-2023.2
