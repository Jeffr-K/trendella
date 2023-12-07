package com.lambsroad.trendella.modules.member.domain.vo

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class Gender(@JsonValue val gender: String) {
    MALE("male"),
    FEMALE("female");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(gender: String) = entries.find { it.gender == gender }
    }
}
