package com.base.base_app.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseModel(@Json(name="_id")
                     val _id:String,
                     @Json(name="name")
                     val name:String,
                     @Json(name="image")
                     val image:String,
                     var isSelected:Boolean=false):Parcelable


