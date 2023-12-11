package com.lambsroad.trendella.modules.brand.presentor.controller

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.modules.brand.application.service.BrandService
import com.lambsroad.trendella.modules.brand.presentor.adapter.BrandRegisterAdapter
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/brand")
class BrandController(
    private val brandService: BrandService
) {

    @PostMapping
    fun registerBrand(@RequestBody @Valid adapter: BrandRegisterAdapter): Result<*> {
        this.brandService.registerBrand(adapter)
        return Result.success("브랜드 입점이 성공적으로 처리되었습니다.", null)
    }
}
