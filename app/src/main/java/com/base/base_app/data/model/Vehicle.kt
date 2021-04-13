package com.base.base_app.data.model

import com.squareup.moshi.Json

 data class Vehicle(
     @Json(name = "_id")
     var _id :String?=null,
     @Json(name = "constructionDate")
     var constructionDate:String="",
     @Json(name = "vehicleModel")
     var vehicleModel :String="",
     @Json(name = "vehicleTonnage")
     var vehicleTonnage :Double?=null

)
