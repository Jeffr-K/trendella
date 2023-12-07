package com.lambsroad.trendella.infrastructure.utils

import org.springframework.http.HttpStatus

class Result<T>(
    val code: HttpStatus,
    val message: String,
    val data: T
) {
    companion object {
        fun <T> success(message: String, data: T): Result<T> {
            return Result(HttpStatus.OK, message, data)
        }

        fun <T> failure(statusCode: HttpStatus, message: String, data: T): Result<T> {
            return Result(statusCode, message, data)
        }
    }
}
