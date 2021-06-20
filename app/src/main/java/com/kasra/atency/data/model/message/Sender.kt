package com.kasra.atency.data.model.message

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sender (
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("Code")
    @Expose
    var code: String? = null,

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
    var nationalCode: String? = null,

    @SerializedName("Address")
    @Expose
    var address: String? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: Any? = null,

    @SerializedName("User")
    @Expose
    var user: User_? = null,

    @SerializedName("ContractType")
    @Expose
    var contractType: Any? = null,

    @SerializedName("Workplaces")
    @Expose
    var workplaces: List<Any>? = null,

    @SerializedName("PersonnelShiftGroup")
    @Expose
    var personnelShiftGroup: Any? = null,

    @SerializedName("ContractStartDate")
    @Expose
    var contractStartDate: String? = null
)