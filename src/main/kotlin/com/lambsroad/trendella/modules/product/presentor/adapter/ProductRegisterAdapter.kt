package com.lambsroad.trendella.modules.product.presentor.adapter

import com.lambsroad.trendella.modules.product.domain.vo.*
import jakarta.validation.constraints.NotNull

data class ProductRegisterAdapter(
    @field:NotNull(message = "상품 제목을 입력해주세요.")
    val title: String,

    @field:NotNull(message = "가격 정보를 입력해주세요.")
    val price: Price,

    @field:NotNull(message = "수량 정보를 입력해주세요.")
    val quantity: Int,

    @field:NotNull(message = "해쉬 태그를 등록해 주세요.")
    val hashTag: MutableList<Tag>,

    @field:NotNull(message = "브랜드 입력(아이디)는 필수 입력 값 입니다.")
    val brandId: Long,

    @field:NotNull(message = "상품 옵션을 선택해주세요.")
    val options: MutableList<Options>,

    @field:NotNull(message = "상품 사진을 입력해주세요.")
    val pictures: MutableList<Picture>,

    @field:NotNull(message = "상품 카테고리 번호를 입력해주세요.")
    val categoryId: Long,

    @field:NotNull(message = "상품 가이드를 입력해주세요.")
    val guidance: Guidance,

    @field:NotNull(message = "상품 정보를 입력해주세요.")
    val information: Information
)
