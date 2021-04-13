package com.base.base_app.data.model

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "phoneNumber")
    val phoneNumber:String,
    @Json(name = "password")
    val password:String
)