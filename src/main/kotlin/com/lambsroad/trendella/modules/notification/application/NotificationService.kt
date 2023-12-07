package com.lambsroad.trendella.modules.notification.application

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val fcm: FirebaseMessaging
) {

    fun sendFcmMessage() {
        val token: String? = null
        val data1: String? = null
        val data2: String? = null

        val message = Message.builder()
            .putData("key1", data1)
            .putData("key2", data2)
            .setToken(token)
            .build()

        val response = fcm.send(message)
        println("Successfully sent message: $response")
        println("recoveryCode: VXKE2AYXZTVHELJR87JZPSRM")
    }
}
