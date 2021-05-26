package com.base.base_app.data.model.checkinout

import androidx.room.PrimaryKey
import com.base.base_app.data.model.workplace.Recorder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AttLogModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("AttendanceType")
    @Expose
    private val attendanceType: AttendanceType? = null,

    @SerializedName("LogDateTime")
    @Expose
    private val logDateTime: String? = null,

    @SerializedName("RegisterationDate")
    @Expose
    private val registerationDate: String? = null,

    @SerializedName("Recorder")
    @Expose
    private val recorder: Recorder? = null,

    @SerializedName("isMissedAttendance")
    @Expose
    private val isMissedAttendance: Boolean? = null
)
