package com.kasra.atency.data.model.update

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import okhttp3.internal.platform.Platform

data class CheckUpdateResponseModel (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Platform")
    @Expose
    var platform: Platform? = null,

    @SerializedName("MinimumCompatibleVersion")
    @Expose
    var minimumCompatibleVersion: MinimumCompatibleVersion? = null,

    @SerializedName("Changelog")
    @Expose
    var changelog: Any? = null,

    @SerializedName("Title")
    @Expose
    var title: String? = null,

    @SerializedName("Description")
    @Expose
    var description: String? = null,

    @SerializedName("VersionNumber")
    @Expose
    var versionNumber: String? = null,

    @SerializedName("VersionCode")
    @Expose
    var versionCode: Int? = null,

    @SerializedName("RegistrationDate")
    @Expose
    var registrationDate: String? = null,

    @SerializedName("UpdateType")
    @Expose
    var updateType: UpdateType? = null,

    @SerializedName("StoreUrl")
    @Expose
    var storeURL: String? = null
)