package com.base.base_app.data.model.message

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LastCustomerMessagePersonnelStatus(
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("ModificationDate")
    @Expose
    var modificationDate: String? = null,

    @SerializedName("Status")
    @Expose
    var status: Status? = null,

    @SerializedName("CustomerMessagePersonnel")
    @Expose
    var customerMessagePersonnel: Any? = null
)