package com.kasra.atency.data.model.paired

import com.kasra.atency.data.model.checkinout.AttLogModel
import com.kasra.atency.data.model.workplace.Recorder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PairedAttendanceListResponseModel (
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("EnterAttendanceLog")
    @Expose
    var enterAttendanceLog: AttLogModel? = null,

    @SerializedName("ExitAttendanceLog")
    @Expose
    var exitAttendanceLog: AttLogModel? = null,

    @SerializedName("Recorder")
    @Expose
    var recorder: Recorder? = null,

    @SerializedName("PairAttendanceType")
    @Expose
    var pairAttendanceType: PairAttendanceType? = null
)