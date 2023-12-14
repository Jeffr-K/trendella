package com.lambsroad.trendella.modules.order.presentor.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController {

    @PostMapping
    fun order() {}

    @DeleteMapping
    fun cancel() {}

    @PatchMapping("/address")
    fun editAddressOrderForm() {}

    @GetMapping
    fun retrieve() {}

    fun retrieveAll() {}
}
