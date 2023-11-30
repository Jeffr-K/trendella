package com.lambsroad.trendella.modules.product.application.service

import com.lambsroad.trendella.modules.product.domain.entities.Product
import com.lambsroad.trendella.modules.product.domain.repositories.ProductRepository
import com.lambsroad.trendella.modules.product.presentor.adapter.ProductRegisterAdapter
import com.lambsroad.trendella.modules.product.presentor.adapter.ProductsQueryAdapter
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository : ProductRepository
) {
    private val modelMapper = ModelMapper()

//    fun registerProduct(product: ProductRegisterAdapter) : Boolean {
//        val newProduct = Product(
//            product.title,
//            product.price,
//            product.url,
//            product.provider
//        )
//
//        this.productRepository.save(newProduct)
//        return true
//    }

    fun getProducts(): List<Product> {
        return productRepository.findAll()
    }

//    private fun mapProductToProductsQueryAdapter(product: Product): ProductsQueryAdapter {
//        return modelMapper.map(product, ProductsQueryAdapter::class.java)
//    }
}
