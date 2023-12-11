package com.lambsroad.trendella.modules.brand.application.service

import com.lambsroad.trendella.modules.brand.application.domain.entities.Brand
import com.lambsroad.trendella.modules.brand.application.domain.repositories.BrandRepository
import com.lambsroad.trendella.modules.brand.application.domain.repositories.BusinessRegistrationRepository
import com.lambsroad.trendella.modules.brand.application.domain.vo.BusinessRegistration
import com.lambsroad.trendella.modules.brand.presentor.adapter.BrandRegisterAdapter
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository,
    private val businessRegistrationRepository: BusinessRegistrationRepository
) {

    @Transactional
    fun registerBrand(adapter: BrandRegisterAdapter): Boolean {

    val newRegistrations = BusinessRegistration(
            adapter.businessRegistration.businessNumber,
            adapter.businessRegistration.contactNumber,
            adapter.businessRegistration.businessEmail,
            adapter.businessRegistration.returnAddress,
            adapter.businessRegistration.businessLocation,
            adapter.businessRegistration.businessRegisteredAt,
            null
        )

        val registration = this.businessRegistrationRepository.save(newRegistrations)
        val brand = Brand(registration)
        this.brandRepository.save(brand)

        return true
    }
}
