package com.lambsroad.trendella.modules.brand.application.domain.repositories

import com.lambsroad.trendella.modules.brand.application.domain.vo.BusinessRegistration
import org.springframework.data.jpa.repository.JpaRepository

interface BusinessRegistrationRepository : JpaRepository<BusinessRegistration, Long> {}
