package com.base.base_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
@Entity(tableName = "Person")
data class Person(
    @PrimaryKey
    @Json(name = "_id")
    val _id: String = "",
    @Json(name = "firstName")
    val firstName: String = "",
    @Json(name = "lastName")
    val lastName: String = "",
    @Json(name = "nationalCode")
    val nationalCode: String,
    @Json(name = "dateOfBirth")
    val dateOfBirth: String,
    @Json(name = "cellPhoneNumber")
    val cellPhoneNumber: String,
    @Json(name = "landPhoneNumber")
    val landPhoneNumber: String
)