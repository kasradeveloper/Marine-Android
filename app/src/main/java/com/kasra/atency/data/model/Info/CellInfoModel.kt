package com.kasra.atency.data.model.Info

import com.kasra.atency.data.model.workplace.Country
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CellInfoModel (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("PushId")
    @Expose
    var pushId: String? = null,

    @SerializedName("IMEI")
    @Expose
    var iMEI: Any? = null,

    @SerializedName("Brand")
    @Expose
    var brand: String? = null,

    @SerializedName("OperationSystem")
    @Expose
    var operationSystem: String? = null,

    @SerializedName("OperationSystemVersion")
    @Expose
    var operationSystemVersion: String? = null,

    @SerializedName("Country")
    @Expose
    var country: Country? = null,

    @SerializedName("User")
    @Expose
    var user: Any? = null,

    @SerializedName("Timezone")
    @Expose
    var timezone: Any? = null,

    @SerializedName("Date")
    @Expose
    var date: String? = null,

    @SerializedName("AppVersion")
    @Expose
    var appVersion: Any? = null,

    @SerializedName("IsActive")
    @Expose
    var isActive: Boolean? = null
)