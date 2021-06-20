package com.kasra.atency.data.model.performance.summary

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PerformanceSummaryReportParamsModel (
    @SerializedName("from")
    @Expose
    var from:Int = 0,

    @SerializedName("size")
    @Expose
    var size:Int = 0,

    @SerializedName("personnelId")
    @Expose
    var personnelId:Int = 0,

    @SerializedName("startDate")
    @Expose
    var startDate: String? = null,

    @SerializedName("endDate")
    @Expose
    var endDate: String? = null
)