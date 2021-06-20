package com.kasra.atency.data.model.update

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MinimumCompatibleVersion (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Platform")
    @Expose
    var platform: Platform? = null,

    @SerializedName("MinimumCompatibleVersion")
    @Expose
    var minimumCompatibleVersion: Any? = null,

    @SerializedName("Changelog")
    @Expose
    var changelog: String? = null,

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
    var updateType: Any? = null
)