package com.base.base_app.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestGroup (
    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("Icon")
    @Expose
    var icon: String? = null
)