package com.lambsroad.trendella.modules.product.domain.vo

import jakarta.persistence.ElementCollection
import jakarta.persistence.Embeddable

@Embeddable
class Tag {
    @ElementCollection
    var hashtags: MutableList<String> = mutableListOf()
}
