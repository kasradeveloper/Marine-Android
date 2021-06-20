package com.kasra.atency.data.model.attendance

import com.kasra.atency.data.model.request.MyRequestsModel
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PortfolioResponseModel(
    @SerializedName("Requests") @Expose
    private var requests: List<MyRequestsModel?>? = null,
    @SerializedName("Id")
    @Expose
    private val id: String? = null,

    @SerializedName("Code")
    @Expose
    private val code: String? = null,

    @SerializedName("FirstName")
    @Expose
    private val firstName: String? = null,

    @SerializedName("LastName")
    @Expose
    private val lastName: String? = null,

    @SerializedName("Fullname")
    @Expose
    private val fullname: String? = null,

    @SerializedName("Active")
    @Expose
    private val active: Boolean? = null,

    @SerializedName("NationalCode")
    @Expose
    private val nationalCode: Any? = null,

    @SerializedName("Address")
    @Expose
    private val address: Any? = null,

    @SerializedName("Tenant")
    @Expose
    private val tenant: Any? = null,

    @SerializedName("User")
    @Expose
    private val user: Any? = null,

    @SerializedName("ContractType")
    @Expose
    private val contractType: Any? = null,

    @SerializedName("Workplaces")
    @Expose
    private val workplaces: List<Any>? = null,

    @SerializedName("Workplace")
    @Expose
    private val workplace: WorkplaceModel? = null,
)