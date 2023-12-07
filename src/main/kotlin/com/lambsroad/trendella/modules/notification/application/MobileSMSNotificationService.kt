package com.lambsroad.trendella.modules.notification.application

import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MobileSMSNotificationService(
    @Value("\${twilio.accountSid}") private val accountSid: String,
    @Value("\${twilio.authToken}") private val authToken: String,
    @Value("\${twilio.phoneNumber}") private val twilioPhoneNumber: String
) {
    init {
        Twilio.init(accountSid, authToken)
    }

    fun sendSms(to: String, message: String) {
        val message = Message.creator(
            PhoneNumber(to),
            PhoneNumber(twilioPhoneNumber),
            message
        ).create()

        println("SMS sent with SID: ${message.sid}")
    }
}
