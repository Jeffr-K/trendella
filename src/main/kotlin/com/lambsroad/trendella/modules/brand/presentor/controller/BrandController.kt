package com.lambsroad.trendella.modules.brand.presentor.controller

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.modules.brand.application.service.BrandService
import com.lambsroad.trendella.modules.brand.presentor.adapter.BrandRegisterAdapter
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/brand")
class BrandController(
    private val brandService: BrandService
) {

    @PostMapping
    fun enter(@RequestBody @Valid adapter: BrandRegisterAdapter): Result<*> {
        this.brandService.registerBrand(adapter)
        return Result.success("브랜드 입점이 성공적으로 처리되었습니다.", null)
    }

    @DeleteMapping
    fun evict(): Result<*> {
        return Result.success("", null)
    }
}
