package com.lambsroad.trendella.modules.product.domain.repositories

import com.lambsroad.trendella.modules.product.domain.entities.Product
import com.lambsroad.trendella.modules.product.domain.entities.QProduct
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class ProductRepositorySupportImpl(
    private val queryFactory: JPAQueryFactory
) : QuerydslRepositorySupport(Product::class.java),
    ProductRepositorySupport {

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
