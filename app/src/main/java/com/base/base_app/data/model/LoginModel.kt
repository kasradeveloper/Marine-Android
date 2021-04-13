package com.base.bime.data.model

import com.base.base_app.data.model.User
import com.squareup.moshi.Json
data class LoginModel(
    @Json(name = "user")
    val user: User,
    @Json(name = "access_token")
    val access_token:String,
    @Json(name = "refresh_token")
    val refresh_token:String

)