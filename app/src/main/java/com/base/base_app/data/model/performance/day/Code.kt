package com.base.base_app.data.model.performance.day

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Code (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("CategoryCode")
    @Expose
    var categoryCode: List<Any>? = null,

    @SerializedName("Description")
    @Expose
    var description: Any? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("code")
    @Expose
    var code: String? = null,

    @SerializedName("Color")
    @Expose
    var color: String? = null,

    @SerializedName("IsRequestNeeded")
    @Expose
    var isRequestNeeded: Boolean? = null
)