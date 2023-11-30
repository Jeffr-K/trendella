package com.lambsroad.trendella.infrastructure.configuration.database//package com.lambsroad.trendella.infrastructure.configuration
//
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.elasticsearch.client.ClientConfiguration
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
//
//
//// https://wiki.yowu.dev/ko/Knowledge-base/Spring-Boot/Learning/073-integrating-spring-boot-with-elasticsearch-for-search-and-analytics
//
//@Configuration
//class ElasticSearchConfig : ElasticsearchConfiguration() {
//    @Value("\${elasticsearch.host}")
//    private val host: String? = null
//
//    @Value("\${elasticsearch.port}")
//    private val port: Int = 0
//
//    override fun clientConfiguration(): ClientConfiguration {
//        return ClientConfiguration.builder()
//            .connectedTo("$host:$port")
//            .build()
//    }
//}
