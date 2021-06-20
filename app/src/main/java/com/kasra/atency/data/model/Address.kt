package com.kasra.atency.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Address (
    @SerializedName("Locale")
    @Expose
    var locale: String? = null,

    @SerializedName("Direction")
    @Expose
    var direction: String? = null,

    @SerializedName("WorkperiodType")
    @Expose
    var workPeriodType: String? = null,

    @SerializedName("PersonnelCode")
    @Expose
    var personnelCode: String? = null,

    @SerializedName("ImageName")
    @Expose
    var imageName: String? = null

)