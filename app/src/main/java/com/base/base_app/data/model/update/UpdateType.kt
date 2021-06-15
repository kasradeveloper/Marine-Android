package com.base.base_app.data.model.update

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateType (
    @SerializedName("Id")
    @Expose
    var id:Int = 0,

    @SerializedName("OrderIndex")
    @Expose
    var orderIndex:Int = 0,

    @SerializedName("Value")
    @Expose
    var value: String? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null
)