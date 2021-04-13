package com.base.bime.data.model

import com.squareup.moshi.Json

data class ConstructionDate(
    @Json(name="_id")
    val _id:String,
    @Json(name="gregorianYear")
    val gregorianYear:String,
    @Json(name="jalaliYear")
    var jalaliYear:String,
    @Json(name="date")
    val date:String
)
