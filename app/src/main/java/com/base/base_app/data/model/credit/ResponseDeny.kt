package com.base.base_app.data.model.credit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseDeny (
    @SerializedName("Code")
    @Expose
    var code: Int? = null,

    @SerializedName("Title")
    @Expose
    var title: Any? = null,

    @SerializedName("Message")
    @Expose
    var message: Any? = null,

    @SerializedName("Success")
    @Expose
    var success: Boolean? = null,

    @SerializedName("Param")
    @Expose
    var param: Any? = null,

    @SerializedName("SeverityLevel")
    @Expose
    var severityLevel: Int? = null
)