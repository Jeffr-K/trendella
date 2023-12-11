package com.lambsroad.trendella.modules.product.presentor.controller

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.modules.product.application.port.CategoryDeletePort
import com.lambsroad.trendella.modules.product.application.port.CategoryEditPort
import com.lambsroad.trendella.modules.product.application.port.CategoryRegisterPort
import com.lambsroad.trendella.modules.product.application.service.CategoryService
import com.lambsroad.trendella.modules.product.presentor.adapter.CategoriesSearchAdapter
import com.lambsroad.trendella.modules.product.presentor.adapter.CategoryDeleteAdapter
import com.lambsroad.trendella.modules.product.presentor.adapter.CategoryEditAdapter
import com.lambsroad.trendella.modules.product.presentor.adapter.CategoryRegisterAdapter
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping
    fun registerCategory(@RequestBody @Valid adapter: CategoryRegisterAdapter): Result<*> {
        this.categoryService.registerCategory(CategoryRegisterPort(adapter.name, adapter.parent))
        return Result.success("카테고리 등록이 성공적으로 처리되었습니다", null)
    }

    @DeleteMapping
    fun deleteCategory(@RequestBody @Valid adapter: CategoryDeleteAdapter): Result<*> {
        this.categoryService.deleteCategory(CategoryDeletePort(adapter.categoryId))
        return Result.success("카테고리 삭제가 성공적으로 처리되었습니다.", null)
    }

    @PutMapping
    fun editCategory(@RequestBody @Valid adapter: CategoryEditAdapter): Result<*> {
        this.categoryService.editCategory(CategoryEditPort(adapter.categoryId, adapter.name))
        return Result.success("카테고리 수정이 성공적으로 완료되었습니다.", null)
    }

    @GetMapping("/list")
    fun getCategories(@RequestBody @Valid adapter: CategoriesSearchAdapter): Result<*> {
        val categories = this.categoryService.getCategories()
        return Result.success("카테고리 목록 조회가 성공적으로 처리되었습니다.", categories)
    }
}
