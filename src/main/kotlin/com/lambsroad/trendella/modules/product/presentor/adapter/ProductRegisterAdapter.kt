package com.lambsroad.trendella.modules.product.presentor.adapter

import com.lambsroad.trendella.modules.product.domain.vo.*
import jakarta.validation.constraints.NotNull

data class ProductRegisterAdapter(
    @field:NotNull(message = "")
    val title: String,

    @field:NotNull(message = "")
    val price: Price,

    @field:NotNull(message = "해쉬 태그를 등록해 주세요.")
    val hashTag: MutableList<Tag>,

    @field:NotNull(message = "브랜드 입력(아이디)는 필수 입력 값 입니다.")
    val brandId: Long,

    @field:NotNull(message = "")
    val options: MutableList<Options>,

    @field:NotNull(message = "")
    val pictures: MutableList<Picture>,

    @field:NotNull(message = "")
    val categoryId: Long,

    @field:NotNull(message = "")
    val guidance: Guidance,

    @field:NotNull(message = "")
    val information: Information
)
