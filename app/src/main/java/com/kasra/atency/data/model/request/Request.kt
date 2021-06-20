package com.kasra.atency.data.model.request

import com.kasra.atency.data.model.attendance.Personnel
import com.kasra.atency.data.model.attendance.Tenant
import com.kasra.atency.data.model.performance.day.AttendanceType
import com.kasra.atency.data.model.workplace.Recorder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Request (
    @SerializedName("ID")
    @Expose
    private val iD: Int? = null,

    @SerializedName("FromDate")
    @Expose
    private val attendanceType: AttendanceType? = null,

    @SerializedName("ToDate")
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
    private val recorder: Recorder? = null
)