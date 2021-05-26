package com.base.base_app.data.model.attendance

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tenant(
    @SerializedName("Id") @Expose
    private var id: String? = null,

    @SerializedName("Manager")
    @Expose
    private val manager: Any? = null,

    @SerializedName("Name")
    @Expose
    private val name: Any? = null,

    @SerializedName("Subdomain")
    @Expose
    private val subdomain: Any? = null,

    @SerializedName("PersonnelCount")
    @Expose
    private val personnelCount: Int? = null,

    @SerializedName("PhoneNumber")
    @Expose
    private val phoneNumber: Any? = null,

    @SerializedName("MobileNumber")
    @Expose
    private val mobileNumber: Any? = null,

    @SerializedName("Address")
    @Expose
    private val address: Any? = null,

    @SerializedName("WorkperiodType")
    @Expose
    private val workperiodType: Any? = null,

    @SerializedName("RHType")
    @Expose
    private val rHType: Any? = null,

    @SerializedName("Type")
    @Expose
    private val type: Any? = null,

    @SerializedName("Parent")
    @Expose
    private val parent: Any? = null,

    @SerializedName("AllowDebt")
    @Expose
    private val allowDebt: Boolean? = null,

    @SerializedName("WebsiteURL")
    @Expose
    private val websiteURL: Any? = null,

    @SerializedName("BankAccountNumber")
    @Expose
    private val bankAccountNumber: Any? = null,

    @SerializedName("BankAccountInfo")
    @Expose
    private val bankAccountInfo: Any? = null,

    @SerializedName("Description")
    @Expose
    private val description: Any? = null,

    @SerializedName("ActivePlan")
    @Expose
    private val activePlan: Any? = null,

    @SerializedName("IsActive")
    @Expose
    private val isActive: Boolean? = null,

    @SerializedName("HolidayCountry")
    @Expose
    private val holidayCountry: Any? = null,

    @SerializedName("Currency")
    @Expose
    private val currency: Any? = null
)
