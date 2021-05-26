package com.base.base_app.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MetaData (
    @SerializedName("Value")
    @Expose
    var value: String? = null
)