package com.base.base_app.data.model.message

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Receiver (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("CustomerMessage")
    @Expose
    var customerMessage: Any? = null,

    @SerializedName("Receiver")
    @Expose
    var receiver: Receiver_? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: Any? = null,

    @SerializedName("CustomerMessagePersonnelStatuses")
    @Expose
    var customerMessagePersonnelStatuses: List<Any>? = null,

    @SerializedName("LastCustomerMessagePersonnelStatus")
    @Expose
    var lastCustomerMessagePersonnelStatus: LastCustomerMessagePersonnelStatus? = null
)