package com.kasra.atency.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TenantModel (
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("Name")
    @Expose
    var name: Any? = null,

    @SerializedName("Subdomain")
    @Expose
    var subdomain: Any? = null,

    @SerializedName("PersonnelCount")
    @Expose
    var personnelCount: Int? = null,

    @SerializedName("PhoneNumber")
    @Expose
    var phoneNumber: Any? = null,

    @SerializedName("MobileNumber")
    @Expose
    var mobileNumber: Any? = null,

    @SerializedName("Address")
    @Expose
    var address: Any? = null,

    @SerializedName("WPType")
    @Expose
    var wPType: Any? = null,

    @SerializedName("RHType")
    @Expose
    var rHType: Any? = null,

    @SerializedName("ManagerEmail")
    @Expose
    var managerEmail: Any? = null
)