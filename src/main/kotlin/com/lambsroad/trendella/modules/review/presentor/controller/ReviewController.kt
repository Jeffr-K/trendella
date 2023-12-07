package com.lambsroad.trendella.modules.review.presentor.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/review")
class ReviewController {

    @PostMapping
    fun registerReview() {

    }

    @PutMapping
    fun editReview() {}

    @DeleteMapping
    fun deleteReview() {}

    @GetMapping
    fun getReview() {}

    @GetMapping("/list")
    fun getReviews() {}

}
