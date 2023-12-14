package com.lambsroad.trendella.modules.product.utils.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.lambsroad.trendella.modules.product.domain.entities.Product

class ProductSerializer : JsonSerializer<Product>() {
    override fun serialize(product: Product, jsonGenerator: JsonGenerator, serializerProvider: SerializerProvider) {
        // Product를 어떻게 직렬화할지 정의
        jsonGenerator.writeStartObject()
        product.id?.let { jsonGenerator.writeNumberField("id", it) }
        jsonGenerator.writeStringField("title", product.title)
        // 추가 필드가 있으면 여기에 계속 추가
        jsonGenerator.writeEndObject()
    }
}
