package com.lambsroad.trendella.modules.member.presentor.controller

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.modules.member.application.port.MemberRegisterAccountPort
import com.lambsroad.trendella.modules.member.application.port.MemberSearchProfilePort
import com.lambsroad.trendella.modules.member.application.service.MemberService
import com.lambsroad.trendella.modules.member.domain.entities.Member
import com.lambsroad.trendella.modules.member.presentor.adapter.MemberDropdownAdapter
import com.lambsroad.trendella.modules.member.presentor.adapter.MemberRegisterAdapter
import com.lambsroad.trendella.modules.member.presentor.adapter.MemberSearchProfileAdapter
import com.lambsroad.trendella.modules.notification.application.MobileSMSNotificationService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService,
    private val notificationService: MobileSMSNotificationService
) {
    @PostMapping
    fun registerMember(@RequestBody @Valid adapter: MemberRegisterAdapter): Result<*> {
        this.memberService.registerMemberAccount(
            MemberRegisterAccountPort(
                adapter.username,
                adapter.email,
                adapter.password,
                adapter.phone,
                adapter.gender,
                adapter.grades,
                adapter.roles
            )
        )

        return Result.success("회원가입이 성공적으로 처리되었습니다.", null)
    }

    @DeleteMapping
    fun dropdown(@RequestBody @Valid adapter: MemberDropdownAdapter): Result<*> {
        this.memberService.dropdownMemberAccount(
            MemberDropdownAdapter(adapter.id)
        )

        return Result.success("회원 탈퇴가 성공적으로 처리되었습니다.", null)
    }

    @GetMapping("/{id}")
    fun hello(@PathVariable("id") id: Int): Member? {
        return this.memberService.getMember(id.toLong())
    }

    @GetMapping("/my-page")
    fun getMyProfilePage(@RequestBody @Valid adapter: MemberSearchProfileAdapter): Result<Member?> {
        val member = this.memberService.getMyProfileInfo(MemberSearchProfilePort(adapter.id))
        return Result.success("회원 조회가 완료되었습니다.", member)
    }
}
