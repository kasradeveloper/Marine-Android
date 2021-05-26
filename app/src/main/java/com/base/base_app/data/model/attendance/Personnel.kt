package com.base.base_app.data.model.attendance

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Personnel(
    @SerializedName("Id") @Expose
    private var id: String? = null,

    @SerializedName("Code")
    @Expose
    private val code: Any? = null,

    @SerializedName("FirstName")
    @Expose
    private val firstName: Any? = null,

    @SerializedName("LastName")
    @Expose
    private val lastName: Any? = null,

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

    @SerializedName("PersonnelShiftGroup")
    @Expose
    private val personnelShiftGroup: Any? = null,

    @SerializedName("ImageUrl")
    @Expose
    private val imageUrl: String? = null
)
