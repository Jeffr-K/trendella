package com.lambsroad.trendella.modules.brand.presentor.adapter

import jakarta.validation.constraints.NotNull

data class BrandRegisterAdapter(
    @field:NotNull(message = "브랜드 입점 전 사업자 등록은 필수 입력 값 입니다.")
    var businessRegistration: BusinessRegistrationAdapter
)
