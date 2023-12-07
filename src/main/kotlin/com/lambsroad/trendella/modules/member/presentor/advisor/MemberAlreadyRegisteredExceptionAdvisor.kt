package com.lambsroad.trendella.modules.member.presentor.advisor

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.infrastructure.utils.logger
import com.lambsroad.trendella.modules.member.domain.exception.UserAlreadyRegisteredException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class MemberAlreadyRegisteredExceptionAdvisor {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyRegisteredException::class)
    protected fun handleUserAlreadyRegisteredException(exception: UserAlreadyRegisteredException): Result<*> {
        logger().info("이미 존재하는 유저입니다.")
        return Result.failure(HttpStatus.BAD_REQUEST, "이미 존재하는 유저입니다.", null)
    }
}
