package com.lambsroad.trendella.infrastructure.utils

import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.Pageable

fun <T> JPAQuery<T>.pagination(pageable: Pageable): JPAQuery<T> {
    return this
        .offset(pageable.offset)
        .limit(pageable.pageSize.toLong())
}
