package com.base.base_app.data.model.credit

import com.base.base_app.data.model.request.RequestType
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CreditParams(
    @SerializedName("ID")
    @Expose
    var iD :Int,

    @SerializedName("Description")
    @Expose
    var description: String? = null,

    @SerializedName("RequestType")
    @Expose
    var requestType: RequestType? = null


    )