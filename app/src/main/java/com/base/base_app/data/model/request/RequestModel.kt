package com.base.base_app.data.model.request

import com.base.base_app.data.model.workplace.WorkplaceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class RequestModel (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Start")
    @Expose
    var start: String? = null,

    @SerializedName("StrStart")
    @Expose
    var strStart: Any? = null,

    @SerializedName("End")
    @Expose
    var end: String? = null,

    @SerializedName("StrEnd")
    @Expose
    var strEnd: Any? = null,

    @SerializedName("ShiftStartTime")
    @Expose
    var shiftStartTime: String? = null,

    @SerializedName("ShiftEndTime")
    @Expose
    var shiftEndTime: String? = null,

    @SerializedName("Amount")
    @Expose
    var amount: String? = null,

    @SerializedName("MetaData")
    @Expose
    var metaData: String? = null,

    @SerializedName("RequestType")
    @Expose
    var requestType: RequestType? = null,

    @SerializedName("Description")
    @Expose
    var description: String? = null,

    @SerializedName("LastRequestStatus")
    @Expose
    var lastRequestStatus: LastRequestStatus? = null,

    @SerializedName("Personnel")
    @Expose
    var personnel: Any? = null,

    @SerializedName("Workplace")
    @Expose
    var workplaceModel: WorkplaceModel? = null,
    var isRejectDescription:Boolean = false,
    var managerDescription: String? = null,
)