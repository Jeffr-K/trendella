package com.lambsroad.trendella.modules.member.application.service

import com.lambsroad.trendella.modules.member.application.port.MemberRegisterAccountPort
import com.lambsroad.trendella.modules.member.application.port.MemberSearchProfilePort
import com.lambsroad.trendella.modules.member.domain.entities.Member
import com.lambsroad.trendella.modules.member.domain.events.MemberRegisteredEvent
import com.lambsroad.trendella.modules.member.domain.exception.MemberNotFoundException
import com.lambsroad.trendella.modules.member.domain.exception.UserAlreadyRegisteredException
import com.lambsroad.trendella.modules.member.domain.repositories.MemberRepository
import com.lambsroad.trendella.modules.member.domain.services.MemberDomainService
import com.lambsroad.trendella.modules.member.presentor.adapter.MemberDropdownAdapter
import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberDomainService: MemberDomainService,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun registerMemberAccount(port: MemberRegisterAccountPort) {
        val isExist: Boolean = this.memberDomainService.isAlreadyMemberExist(port.email)

        when {
            isExist  -> { throw UserAlreadyRegisteredException(HttpStatus.ALREADY_REPORTED) }
            else -> {
                val member = Member(
                    port.username,
                    port.email,
                    port.password,
                    port.phone,
                    port.gender,
                    port.grade,
                    port.roles
                )
                this.memberRepository.save(member)

                this.applicationEventPublisher.publishEvent(MemberRegisteredEvent("jeffrey", "jeff.cofos@gmail.com"))
            }
        }
    }
    //  publishEvent -> [Event] <-
    fun dropdownMemberAccount(port: MemberDropdownAdapter) {
        val member = this.memberDomainService.getMemberById(port.id)

        when {
            member == null -> { throw MemberNotFoundException(HttpStatus.NOT_FOUND) }
            else -> {
                this.memberRepository.deleteMemberAccount(member)
            }
        }
    }

    fun getMember(id: Long): Member? {
        return this.memberRepository.findMemberById(id)
    }

    fun getMembers(): List<Member?> {
        return this.memberRepository.findAll()
    }

    fun updateEmailAccount() {}

    fun updateAccountPassword() {}

    fun updateProfilePhoto() {}

    fun updateMemberName() {}

    fun updateMemberNickname() {}

    fun authenticateMemberMobilePhone() {}

    fun getMyProfileInfo(port: MemberSearchProfilePort): Member? {
        return this.memberRepository.getMemberProfile(port.id)
    }

}
