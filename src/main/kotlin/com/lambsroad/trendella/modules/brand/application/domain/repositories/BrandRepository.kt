package com.lambsroad.trendella.modules.brand.application.domain.repositories

import com.lambsroad.trendella.modules.brand.application.domain.entities.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository : JpaRepository<Brand, Long> {
}
