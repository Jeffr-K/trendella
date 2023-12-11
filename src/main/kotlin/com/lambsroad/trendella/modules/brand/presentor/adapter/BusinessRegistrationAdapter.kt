package com.lambsroad.trendella.modules.brand.presentor.adapter

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class BusinessRegistrationAdapter(
    val businessNumber: String,
    val contactNumber: String,
    val businessEmail: String,
    val returnAddress: String,
    val businessLocation: String,

    @JsonFormat(pattern = "yyyy-MM-dd")
    var businessRegisteredAt: Date
) {}
