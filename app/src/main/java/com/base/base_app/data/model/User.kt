package com.base.base_app.data.model

import androidx.room.Entity
import com.base.base_app.data.model.Person
import com.squareup.moshi.Json

data class User(
    @Json(name = "_id")
    val _id: String = "",
    @Json(name = "phoneNumber")
    val phoneNumber: String = "",
    @Json(name = "email")
    val email: String = "",
    @Json(name = "person")
    val person: Person
)