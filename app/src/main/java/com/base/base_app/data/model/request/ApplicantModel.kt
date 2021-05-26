package com.base.base_app.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApplicantModel (
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("Code")
    @Expose
    var code: Any? = null,

    @SerializedName("FirstName")
    @Expose
    var firstName: String? = null,

    @SerializedName("LastName")
    @Expose
    var lastName: String? = null,

    @SerializedName("Fullname")
    @Expose
    var fullname: String? = null,

    @SerializedName("Active")
    @Expose
    var active: Boolean? = null,

    @SerializedName("NationalCode")
    @Expose
    var nationalCode: Any? = null,

    @SerializedName("Address")
    @Expose
    var address: Any? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: Any? = null,

    @SerializedName("User")
    @Expose
    var user: Any? = null,

    @SerializedName("ContractType")
    @Expose
    var contractType: Any? = null,

    @SerializedName("Workplaces")
    @Expose
    var workplaces: List<Any>? = null,
)