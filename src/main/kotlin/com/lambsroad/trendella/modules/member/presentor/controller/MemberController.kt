package com.lambsroad.trendella.modules.member.presentor.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController {

    @GetMapping("/greet")
    fun hello(): String {
        return "Hello, World!"
    }
}
