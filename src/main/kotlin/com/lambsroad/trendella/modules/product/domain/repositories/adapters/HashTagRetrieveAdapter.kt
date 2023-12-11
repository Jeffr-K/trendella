package com.lambsroad.trendella.modules.product.domain.repositories.adapters

import com.lambsroad.trendella.modules.product.domain.vo.Tag

data class HashTagRetrieveAdapter(
    val id: Long?,
    val name: String
) {
    companion object {
        fun from(tag: Tag): HashTagRetrieveAdapter {
            return HashTagRetrieveAdapter(tag.id, tag.name)
        }
    }
}
