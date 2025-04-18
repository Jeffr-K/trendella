package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.infrastructure.database.adapters.ProductDetailRetrieveAdapter
import com.lambsroad.trendella.infrastructure.database.adapters.QProductDetailRetrieveAdapter
import com.lambsroad.trendella.modules.product.domain.entities.Product
import com.lambsroad.trendella.modules.product.domain.entities.QCategory
import com.lambsroad.trendella.modules.product.domain.entities.QProduct
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.transaction.Transactional
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class ProductRepositorySupportImpl(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(Product::class.java),
    ProductRepositorySupport {

    /*
     * 1. @QueryProjection
     * 2. @Projections.constructor()
     *
     * TODO: ExpressionUtils 학습
     * TODO: Fetch Join 학습
    */
    override fun retrieveProductProjection(productId: Long): ProductDetailRetrieveAdapter? {
        return this.queryFactory
            .select(
                QProductDetailRetrieveAdapter(
                QProduct.product.id,
                QProduct.product.title,
                QProduct.product.price,
                QProduct.product.createdAt,
                QProduct.product.updatedAt,
                QCategory.category,
//                QBrand.brand,
//                QGuidance.guidance,
//                QInformation.information,
//                QOptions.options,
//                QPicture.picture,
//                QTag.tag
            )
            )
            .from(QProduct.product)
            .join(QProduct.product.category)
//            .join(QProduct.product.brand)
//            .join(QProduct.product.guidance)
//            .join(QProduct.product.information)
//            .join(QProduct.product.options)
//            .join(QProduct.product.pictures)
//            .join(QProduct.product.hashtags)
            .where(QProduct.product.id.eq(productId))
            .fetchOne()
    }

    override fun retrieveProduct(productId: Long): Product? {
        return this.queryFactory
            .selectFrom(QProduct.product)
            .join(QProduct.product.category).fetchJoin()
            .join(QProduct.product.brand).fetchJoin()
            .join(QProduct.product.guidance).fetchJoin()
            .join(QProduct.product.information).fetchJoin()
            .join(QProduct.product.options)
            .join(QProduct.product.pictures)
            .join(QProduct.product.hashtags)
            .where(QProduct.product.id.eq(productId))
            .fetchOne()
    }

    @Transactional
    override fun updateProductQuantity(productId: Long) {
        val product = this.retrieveProduct(productId)
            ?: throw IllegalStateException("현재 상품이 존재하지 않습니다.")

        this.queryFactory
            .update(QProduct.product)
            .set(QProduct.product.quantity, product.quantity + 1)
            .where(QProduct.product.id.eq(productId))
            .execute()
    }

    // TODO: [PageImpl 개선기](https://junior-datalist.tistory.com/342)
    // TODO: [OrderSpecifier](https://dingdingmin-back-end-developer.tistory.com/entry/Springboot-JPA-Querydsl-%EB%8F%99%EC%A0%81-%EC%A0%95%EB%A0%AC-OrderSpecifier)
    override fun retrieveProducts(pageable: Pageable): PageImpl<Product> {
//        return queryFactory
//            .selectFrom(QProduct.product)
//            .join(QProduct.product.category).fetchJoin()
//            .join(QProduct.product.brand).fetchJoin()
//            .join(QProduct.product.guidance).fetchJoin()
//            .join(QProduct.product.information).fetchJoin()
//            .join(QProduct.product.options)
//            .join(QProduct.product.pictures)
//            .join(QProduct.product.hashtags)
//            .pagination(pageable)
//            .orderBy(QProduct.product.title.desc())
//            .fetch()
        val query = queryFactory
            .selectFrom(QProduct.product)
            .join(QProduct.product.category).fetchJoin()
            .join(QProduct.product.brand).fetchJoin()
            .join(QProduct.product.guidance).fetchJoin()
            .join(QProduct.product.information).fetchJoin()
            .join(QProduct.product.options)
            .join(QProduct.product.pictures)
            .join(QProduct.product.hashtags)

        val content = query
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .orderBy()
            .fetch()

        val totalCount = query.fetch().size.toLong()

        return PageImpl(content, pageable, totalCount)
    }
}
