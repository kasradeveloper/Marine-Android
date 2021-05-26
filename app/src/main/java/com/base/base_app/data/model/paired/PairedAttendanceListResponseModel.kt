package com.base.base_app.data.model.paired

import com.base.base_app.data.model.checkinout.AttLogModel
import com.base.base_app.data.model.workplace.Recorder
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