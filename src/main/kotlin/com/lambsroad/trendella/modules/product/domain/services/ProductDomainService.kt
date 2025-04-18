package com.lambsroad.trendella.modules.product.domain.services

import com.lambsroad.trendella.modules.product.domain.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDomainService(
    private val productRepository: ProductRepository
) {
    fun checkIsPossibleToPurchase(productId: Long): Boolean {
        val product = productRepository.retrieveProduct(productId) ?: return false

        return when (product.quantity) {
            0 -> false
            else -> true
        }
    }

    fun changeProductQuantity(productId: Long) {
        this.productRepository.updateProductQuantity(productId)
    }
}
