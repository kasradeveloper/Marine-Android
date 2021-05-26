package com.base.base_app.data.model.message

import com.base.base_app.data.model.attendance.Personnel
import com.base.base_app.data.model.ticket.Role
import com.base.base_app.data.model.workplace.Country
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("DisplayName")
    @Expose
    var displayName: Any? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: Any? = null,

    @SerializedName("Roles")
    @Expose
    var roles: List<Role>? = null,

    @SerializedName("Culture")
    @Expose
    var culture: Any? = null,

    @SerializedName("IsActive")
    @Expose
    var isActive: Boolean? = null,

    @SerializedName("Personnel")
    @Expose
    var personnel: Personnel? = null,

    @SerializedName("NormalizedEmail")
    @Expose
    var normalizedEmail: String? = null,

    @SerializedName("NormalizedUserName")
    @Expose
    var normalizedUserName: String? = null,

    @SerializedName("Country")
    @Expose
    var country: Country? = null,

    @SerializedName("IsPasswordChange")
    @Expose
    var isPasswordChange: Boolean? = null,

    @SerializedName("CellPhoneInfo")
    @Expose
    var cellPhoneInfo: Any? = null,

    @SerializedName("UserName")
    @Expose
    var userName: String? = null,

    @SerializedName("Email")
    @Expose
    var email: String? = null,

    @SerializedName("EmailConfirmed")
    @Expose
    var emailConfirmed: Boolean? = null,

    @SerializedName("PasswordHash")
    @Expose
    var passwordHash: Any? = null,

    @SerializedName("SecurityStamp")
    @Expose
    var securityStamp: Any? = null,

    @SerializedName("ConcurrencyStamp")
    @Expose
    var concurrencyStamp: String? = null,

    @SerializedName("PhoneNumber")
    @Expose
    var phoneNumber: String? = null,

    @SerializedName("PhoneNumberConfirmed")
    @Expose
    var phoneNumberConfirmed: Boolean? = null,

    @SerializedName("TwoFactorEnabled")
    @Expose
    var twoFactorEnabled: Boolean? = null,

    @SerializedName("LockoutEnd")
    @Expose
    var lockoutEnd: Any? = null,

    @SerializedName("LockoutEnabled")
    @Expose
    var lockoutEnabled: Boolean? = null,

    @SerializedName("AccessFailedCount")
    @Expose
    var accessFailedCount: Int? = null

)