package com.lambsroad.trendella.modules.product.presentor.controller

import com.lambsroad.trendella.modules.product.application.service.ProductService
import com.lambsroad.trendella.modules.product.domain.entities.Product
import com.lambsroad.trendella.modules.product.presentor.adapter.ProductRegisterAdapter
import com.lambsroad.trendella.modules.product.presentor.adapter.ProductsQueryAdapter
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
class ProductController(
    private val productService: ProductService
) {
//    @PostMapping("/creation")
//    fun registerProduct(@RequestBody product: ProductRegisterAdapter): ResponseEntity<Boolean> =
//        ResponseEntity.ok().body(this.productService.registerProduct(product))


    @GetMapping("/list")
    fun getProducts() : ResponseEntity<List<Product>> =
        ResponseEntity.ok().body(this.productService.getProducts())

}
