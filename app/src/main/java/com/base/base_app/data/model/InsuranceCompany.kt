package com.base.bime.data.model

import com.squareup.moshi.Json

data class InsuranceCompany(
    @Json(name = "image")
    val image:String,
    @Json(name = "name")
    val name:String,
    @Json(name = "_id")
    val _id:String,
    @Json(name = "price")
    val price:Double
)
