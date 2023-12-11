package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.vo.Guidance
import org.springframework.data.jpa.repository.JpaRepository


interface ProductGuidanceRepository : JpaRepository<Guidance, Long>{
}
