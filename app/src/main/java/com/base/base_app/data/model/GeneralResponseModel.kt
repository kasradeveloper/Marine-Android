package com.base.base_app.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeneralResponseModel (
    @SerializedName("Code")
    @Expose
    var code: String? = null,

    @SerializedName("Title")
    @Expose
    var title: String? = null,

    @SerializedName("Message")
    @Expose
    var message: String? = null,

    @SerializedName("Success")
    @Expose
    var success: Boolean? = null,

    @SerializedName("Param")
    @Expose
    var param: Any? = null,

    @SerializedName("SeverityLevel")
    @Expose
    var severityLevel: Int? = null,

    @SerializedName("Data")
    @Expose
    var data: Any? = null
)