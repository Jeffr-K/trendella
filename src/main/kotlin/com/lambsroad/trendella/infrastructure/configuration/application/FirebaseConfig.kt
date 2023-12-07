package com.lambsroad.trendella.infrastructure.configuration.application

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.InputStream

@Configuration
class FirebaseConfig {

    @Bean
    fun init(): FirebaseApp {
        val account: InputStream = ClassPathResource("firebase-admin-sdk.json")
            .inputStream

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(account))
            .setDatabaseUrl("https://trendella-22a4f.firebaseio.com")
            .build()

        return FirebaseApp.initializeApp(options)
    }

    @Bean
    fun initMessage(firebaseApp: FirebaseApp): FirebaseMessaging {
        return FirebaseMessaging.getInstance(firebaseApp)
    }
}
