package com.kasra.atency.data.model.portfolio

import com.kasra.atency.data.model.request.MyRequestsModel
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PortfolioResponseModel(

    @SerializedName("Requests")
    @Expose
    var requests: List<MyRequestsModel>? = null,

    @SerializedName("Id")
    @Expose
    var id: String,

    @SerializedName("Code")
    @Expose
    var code: String,

    @SerializedName("FirstName")
    @Expose
    var firstName: String,

    @SerializedName("LastName")
    @Expose
    var lastName: String,

    @SerializedName("Fullname")
    @Expose
    var fullname: String,

    @SerializedName("Active")
    @Expose
    var active: Boolean,

    @SerializedName("NationalCode")
    @Expose
    var nationalCode: Any,

    @SerializedName("Address")
    @Expose
    var address: Any,

    @SerializedName("Tenant")
    @Expose
    var tenant: Any,

    @SerializedName("User")
    @Expose
    var user: Any,

    @SerializedName("ContractType")
    @Expose
    var contractType: Any,

    @SerializedName("Workplaces")
    @Expose
    var workplaces: List<Any>? = null,

    @SerializedName("Workplace")
    @Expose
    var workplace: WorkplaceModel? = null

)