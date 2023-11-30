package com.lambsroad.trendella.modules.member.presentor.controller

import com.lambsroad.trendella.modules.member.application.service.MemberService
import com.lambsroad.trendella.modules.member.domain.entities.Member
import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping
    fun registerMember() {
        return this.memberService.registerUser()
    }

    @GetMapping("/{id}")
    fun hello(@PathVariable("id") id: Int): Member? {
        return this.memberService.getUser(id.toLong())
    }
}
