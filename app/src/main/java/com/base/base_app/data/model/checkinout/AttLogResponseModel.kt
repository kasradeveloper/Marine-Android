package com.base.base_app.data.model.checkinout

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AttLogResponseModel(

    @SerializedName("Code")
    @Expose
    var code: String? = null,

    @SerializedName("Title")
    @Expose
    var title: String? = null,

    @SerializedName("Message")
    @Expose
    var message: Any? = null,

    @SerializedName("Success")
    @Expose
    var success: Boolean? = null,

    @SerializedName("Param")
    @Expose
    var param: Any? = null
)