package com.lambsroad.trendella.infrastructure.configuration.database

import org.springframework.beans.factory.annotation.Value
//import org.springframework.cache.CacheManager
//import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
//import org.springframework.data.redis.cache.RedisCacheConfiguration
//import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
//import org.springframework.data.redis.serializer.RedisSerializationContext
//import org.springframework.data.redis.serializer.StringRedisSerializer

//https://karla.tistory.com/m/18

@Configuration
//@EnableCaching
class RedisConfig {
    @Value("\${spring.data.redis.host}")
    private val host: String? = null

    @Value("w\${spring.data.redis.port}")
    private val port: String? = null

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, String> {
        val redisTemplate: RedisTemplate<String, String> = RedisTemplate<String, String>()
        redisTemplate.connectionFactory = redisConnectionFactory()
        return redisTemplate
    }

//    @Bean
//    fun redisTemplate(): RedisTemplate<String, SendingMsgDTO> {
//        val redisTemplate: RedisTemplate<String, SendingMsgDTO> = RedisTemplate<String, SendingMsgDTO>()
//        redisTemplate.setConnectionFactory(redisConnectionFactory())
//        return redisTemplate
//    }
//
//    @Bean
//    fun CacheManager(cf: RedisConnectionFactory?): CacheManager {
//        val redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer<String>(StringRedisSerializer()))
//            .serializeValuesWith(
//                RedisSerializationContext.SerializationPair.fromSerializer<String>(
//                    StringRedisSerializer()
//                )
//            )
//            .entryTtl(Duration.ofMinutes(3L))
//        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(cf!!)
//            .cacheDefaults(redisCacheConfiguration).build()
//    }
}
