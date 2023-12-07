package com.lambsroad.trendella.modules.member.domain.exception

import org.springframework.http.HttpStatus

class MemberNotFoundException(statusCode: HttpStatus) : RuntimeException() {
    val code: HttpStatus = statusCode
    override val message: String = "회원을 찾을 수 없습니다."
}
