package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.vo.Information
import org.springframework.data.jpa.repository.JpaRepository

interface ProductInformationRepository : JpaRepository<Information, Long> {
}
