package com.lambsroad.trendella.infrastructure.security

import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class ApplicationSecurityConfig {
//    private val jwtAuthenticationFilter: JwtAuthenticationFilter? = null
//    private val jwtAuthenticationExceptionFilter: JwtAuthenticationExceptionFilter? = null

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { obj: CsrfConfigurer<HttpSecurity> -> obj.disable() }
//        http.cors { cors -> cors.disable() }
        http.authorizeHttpRequests(
            Customizer { request ->
                request
                    .requestMatchers("/member/**").permitAll()
                    .requestMatchers("/product/**").permitAll()
                    .requestMatchers("/user/signup").permitAll()
                    .requestMatchers("/auth/signin/**", "/auth/signout/**").permitAll()
                    .requestMatchers("/swagger-ui/**").permitAll()
                    .requestMatchers("/api-docs/**").permitAll()
                    .requestMatchers("/actuator/**").permitAll()
                    .requestMatchers("/product/**").permitAll()
                    .requestMatchers("/exception/**").permitAll()
                    .anyRequest().authenticated()
            }
        )
        http.sessionManagement { sessionManagement: SessionManagementConfigurer<HttpSecurity?> ->
            sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
            )
        }
//        http
//            .addFilterBefore(jwtAuthenticationExceptionFilter, BasicAuthenticationFilter::class.java)
//            .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter::class.java)
        return http.build()
    }

    @get:Bean
    val passwordEncoder: PasswordEncoder
        get() = BCryptPasswordEncoder()

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.addAllowedOrigin("http://localhost:3000") // 허용할 도메인을 지정
        config.addAllowedMethod("*")
        config.addAllowedHeader("*")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
