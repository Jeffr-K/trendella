package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.vo.Tag
import org.springframework.data.jpa.repository.JpaRepository


interface ProductHashTagRepository : JpaRepository<Tag, Long> {
}
