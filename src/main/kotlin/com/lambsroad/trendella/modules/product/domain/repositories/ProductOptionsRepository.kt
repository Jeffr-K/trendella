package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.vo.Options
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionsRepository : JpaRepository<Options, Long> {
}
