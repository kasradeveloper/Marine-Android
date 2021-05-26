package com.base.base_app.data.model.attendance

import com.base.base_app.data.model.performance.day.AttendanceType
import com.base.base_app.data.model.request.RequestModel
import com.base.base_app.data.model.workplace.Recorder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AttendanceLogResponseModel(
    @SerializedName("ID")
    @Expose
    private var iD: Int? = null,
    @SerializedName("AttendanceType")
    @Expose
    private val attendanceType: AttendanceType? = null,
    @SerializedName("LogDateTime")
    @Expose
    private val logDateTime: String? = null,
    @SerializedName("Personnel")
    @Expose
    private val personnel: Personnel? = null,
    @SerializedName("Tenant")
    @Expose
    private val tenant: Tenant? = null,
    @SerializedName("RegisterationDate")
    @Expose
    private val registerationDate: String? = null,
    @SerializedName("Recorder")
    @Expose
    private val recorder: Recorder? = null,
    @SerializedName("isMissedAttendance")
    @Expose
    private val isMissedAttendance: Boolean? = null,
    @SerializedName("Request")
    @Expose
    private val request: RequestModel? = null

)
