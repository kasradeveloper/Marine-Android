package com.kasra.atency.data.model.performance.summary

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PerformanceSummaryReportResponseModel (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("StartDate")
    @Expose
    var startDate: String? = null,

    @SerializedName("EndDate")
    @Expose
    var endDate: String? = null,

    @SerializedName("TotalAbsenceHours")
    @Expose
    var totalAbsenceHours: String? = null,

    @SerializedName("TotalAbsenceDays")
    @Expose
    var totalAbsenceDays: Int? = null,

    @SerializedName("TotlaOvertimeHours")
    @Expose
    var totalOvertimeHours: String? = null,

    @SerializedName("TotalLeaveHours")
    @Expose
    var totalLeaveHours: String? = null,

    @SerializedName("TotalLeaveDays")
    @Expose
    var totalLeaveDays: Int? = null,

    @SerializedName("TotalOutdoorDutyHours")
    @Expose
    var totalOutdoorDutyHours: String? = null,

    @SerializedName("TotalOutdoorDutyDays")
    @Expose
    var totalOutdoorDutyDays: Int? = null,

    @SerializedName("TotalPresence")
    @Expose
    var totalPresence: String? = null,

    @SerializedName("ShiftPresence")
    @Expose
    var shiftPresence: String? = null,

    @SerializedName("TotalPresenceHours")
    @Expose
    var totalPresenceHours: String? = null,

    @SerializedName("ShiftPresenceHours")
    @Expose
    var shiftPresenceHours: String? = null,
)