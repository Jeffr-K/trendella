package com.lambsroad.trendella.modules.product.utils.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.lambsroad.trendella.modules.product.domain.entities.Category

class CategorySerializer : JsonSerializer<Category>() {
    override fun serialize(category: Category, jsonGenerator: JsonGenerator, serializerProvider: SerializerProvider) {
        jsonGenerator.writeStartObject()
        category.id?.let { jsonGenerator.writeNumberField("id", it) }
        jsonGenerator.writeStringField("name", category.name)
        // 추가 필드가 있으면 여기에 계속 추가

        // 상위 카테고리 정보도 포함
        val parent = category.parent
        if (parent != null) {
            jsonGenerator.writeObjectFieldStart("parent")
            parent.id?.let { jsonGenerator.writeNumberField("id", it) }
            jsonGenerator.writeStringField("name", parent.name)
            // 추가 필드가 있으면 여기에 계속 추가
            jsonGenerator.writeEndObject()
        }

        jsonGenerator.writeEndObject()
    }
}
