package com.lambsroad.trendella.modules.product.presentor.controller

import com.lambsroad.trendella.infrastructure.utils.Result
import com.lambsroad.trendella.modules.product.application.port.ProductRegisterPort
import com.lambsroad.trendella.modules.product.application.port.ProductRetrievePort
import com.lambsroad.trendella.modules.product.application.service.ProductService
import com.lambsroad.trendella.modules.product.presentor.adapter.ProductRegisterAdapter
import com.lambsroad.trendella.modules.product.presentor.adapter.ProductRetrieveAdapter
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
class ProductController(
    private val productService: ProductService
) {
    @PostMapping
    fun registerProduct(@RequestBody @Valid adapter: ProductRegisterAdapter): Result<*> {
        this.productService.registerProduct(
            ProductRegisterPort(
                adapter.title,
                adapter.price,
                adapter.hashTag,
                adapter.brandId,
                adapter.options,
                adapter.pictures,
                adapter.categoryId,
                adapter.guidance,
                adapter.information
            )
        )

        return Result.success("상품 등록이 성공적으로 처리되었습니다.", null)
    }

    @DeleteMapping
    fun deleteProduct() {}

    @PutMapping
    fun editProduct() {}

    @GetMapping
    fun getProduct(@RequestBody @Valid adapter: ProductRetrieveAdapter): Result<*> {
        val product = this.productService.getProduct(ProductRetrievePort(adapter.productId))
        return Result.success("상품 조회가 성공적으로 처리되었습니다.", product)
    }

    @GetMapping("/list")
    fun getProducts(pageable: Pageable): Result<*> {
        val products = this.productService.getProducts(pageable)
        return Result.success("상품 목록 조회가 성공적으로 처리되었습니다.", products)
    }

}
