package com.kasra.atency.data.model.credit

import com.kasra.atency.data.model.request.RequestType
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