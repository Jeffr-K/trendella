package com.lambsroad.trendella.modules.product.application.service

import com.lambsroad.trendella.modules.brand.application.domain.repositories.BrandRepository
import com.lambsroad.trendella.modules.product.application.port.ProductRegisterPort
import com.lambsroad.trendella.modules.product.application.port.ProductRetrievePort
import com.lambsroad.trendella.modules.product.domain.entities.Product
import com.lambsroad.trendella.modules.product.domain.factories.of
import com.lambsroad.trendella.modules.product.domain.repositories.*
import com.lambsroad.trendella.modules.product.domain.vo.*
import jakarta.transaction.Transactional
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository,
    private val categoryRepository: CategoryRepository,
    private val productGuidanceRepository: ProductGuidanceRepository,
    private val productInformationRepository: ProductInformationRepository,
    private val productOptionsRepository: ProductOptionsRepository,
    private val productHashTagRepository: ProductHashTagRepository,
    private val productPictureRepository: ProductPictureRepository
) {

    @Transactional
    fun registerProduct(port: ProductRegisterPort) : Boolean {
        val options = port.options.map {
            val option = Options(it.type, it.name, it.price, it.product)
            this.productOptionsRepository.save(option)
        }.toMutableList()

        val hashtags = port.hashTag.map {
            val tag = Tag(it.name)
            this.productHashTagRepository.save(tag)
        }.toMutableList()

        val pictures = port.pictures.map {
            val picture = Picture(it.usages, it.url, it.representative, it.sequence, null)
            this.productPictureRepository.save(picture)
        }.toMutableList()

        val guidance = this.productGuidanceRepository.save(
            Guidance.of(port.guidance)
        )

        val information = this.productInformationRepository.save(
            Information.of(port.information)
        )

        val brand = this.brandRepository
            .findById(port.brandId)
            .orElseThrow { IllegalArgumentException("찾고자 하는 브랜드가 없습니다: ${port.brandId}") }

        val category = this.categoryRepository
            .getCategory(port.categoryId)
            ?: throw IllegalArgumentException("찾고자 하는 카테고리가 없습니다: ${port.brandId}")

        val product = Product(
            port.title,
            port.price,
            pictures,
            hashtags,
            brand,
            options,
            category,
            guidance,
            information
        )

        this.productRepository.save(product)
        return true
    }


    fun deleteProduct() {}

    fun editProduct() {}


    fun getProduct(port: ProductRetrievePort): Product? {
        return this.productRepository.retrieveProduct(port.productId)
            ?: throw IllegalArgumentException("찾으시는 상품이 존재하지 않습니다. ID: ${port.productId}")
    }
    fun getProducts(pageable: Pageable): PageImpl<Product> {
        return productRepository.retrieveProducts(pageable)
    }

}
