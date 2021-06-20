package com.kasra.atency.data.model.performance.day

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DayTimelineResponseModel (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("ShiftName")
    @Expose
    var shiftName: String? = null,

    @SerializedName("Date")
    @Expose
    var date: String? = null,

    @SerializedName("DaySections")
    @Expose
    var daySections: List<DaySection>? = null
)