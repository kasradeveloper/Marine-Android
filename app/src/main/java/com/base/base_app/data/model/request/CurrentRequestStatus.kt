package com.base.base_app.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentRequestStatus (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Description")
    @Expose
    var description: String? = null,

    @SerializedName("RegistrationDate")
    @Expose
    var registrationDate: String? = null,

    @SerializedName("Status")
    @Expose
    var status: Int? = null,

    @SerializedName("LastStatus")
    @Expose
    var lastStatus: LastRequestStatus? = null
)