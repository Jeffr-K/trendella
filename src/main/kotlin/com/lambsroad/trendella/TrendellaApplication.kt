package com.lambsroad.trendella

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class TrendellaApplication

fun main(args: Array<String>) {
    runApplication<TrendellaApplication>(*args)
}
