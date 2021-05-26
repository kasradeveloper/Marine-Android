package com.base.base_app.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestTypeAdd (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Code")
    @Expose
    var code: String? = null


)