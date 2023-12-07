package com.lambsroad.trendella.modules.member.presentor.advisor

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.infrastructure.utils.logger
import com.lambsroad.trendella.modules.member.domain.exception.MemberNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class MemberNotFoundExceptionAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MemberNotFoundException::class)
    protected fun handleMemberNotFoundException(exception: MemberNotFoundException): Result<*> {
        logger().info("삭제할 회원이 존재하지 않습니다.")
        return Result.failure(HttpStatus.NOT_FOUND, "삭제할 회원이 존재하지 않습니다.", null)
    }
}
