package com.kasra.atency.data.model.performance.day

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Point (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("LogDateTime")
    @Expose
    var logDateTime: String? = null,

    @SerializedName("isMissedAttendance")
    @Expose
    var isMissedAttendance: Boolean? = null,

    @SerializedName("MadeByRequest")
    @Expose
    var madeByRequest: Boolean? = null,

    @SerializedName("AttendanceType")
    @Expose
    var attendanceType: AttendanceType? = null
)