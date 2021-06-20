package com.kasra.atency.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestClass (
    @SerializedName("ID")
    @Expose
    var iD: Int? = null,
    @SerializedName("Name")
    @Expose
    var name: String? = null
)