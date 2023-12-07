package com.lambsroad.trendella.modules.member.domain.vo

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class Grades(@JsonValue val grades: String) {
    BRONZE("bronze"),
    SILVER("silver"),
    GOLD("gold"),
    PLATINUM("platinum"),
    DIAMOND("diamond");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(grades: String) = entries.find { it.grades == grades }
    }
}
