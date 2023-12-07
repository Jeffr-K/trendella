package com.lambsroad.trendella.modules.member.domain.vo

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class Roles(@JsonValue val role: String) {
    MEMBER("member"),
    ADMINISTRATOR("administrator"),
    PROVIDER("provider");

    companion object {
        @JvmStatic
        @JsonCreator
        fun set(role: String) = Roles.entries.find { it.role == role }
    }
}
