package com.lambsroad.trendella.modules.member.domain.exception

import org.springframework.http.HttpStatus

class UserAlreadyRegisteredException(statusCode: HttpStatus) : RuntimeException() {
    val code: HttpStatus = statusCode
    override val message: String = "이미 가입된 유저 입니다."
}
