package com.kasra.atency.data.model.ticket

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Role (
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("Description")
    @Expose
    var description: String? = null
)