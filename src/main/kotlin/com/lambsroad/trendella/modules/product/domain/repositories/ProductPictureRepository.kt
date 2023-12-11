package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.vo.Picture
import org.springframework.data.jpa.repository.JpaRepository

interface ProductPictureRepository : JpaRepository<Picture, Long> {
}
