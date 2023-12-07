package com.lambsroad.trendella.modules.review.presentor.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comment")
class CommentController {

    @PostMapping
    fun registerComment() {}

    @PutMapping
    fun editComment() {}

    @DeleteMapping
    fun deleteComment() {}

    @GetMapping
    fun getComment() {}

    @GetMapping("/list")
    fun getComments() {}
}
