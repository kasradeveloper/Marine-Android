package com.kasra.atency.data.model.performance.day

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DayTimelineParamsModel (
    @SerializedName("from")
    @Expose
    var from:Int = 1,

    @SerializedName("size")
    @Expose
    var size:Int = 10,

    @SerializedName("personnelId")
    @Expose
    var personnelId:Int = 0,

    @SerializedName("date")
    @Expose
    var date: String? = null
)