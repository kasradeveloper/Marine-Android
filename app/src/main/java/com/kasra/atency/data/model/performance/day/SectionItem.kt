package com.kasra.atency.data.model.performance.day

import com.kasra.atency.data.model.request.RequestModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SectionItem (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("StartPoint")
    @Expose
    var startPoint: Point? = null,

    @SerializedName("EndPoint")
    @Expose
    var endPoint: Point? = null,

    @SerializedName("Code")
    @Expose
    var code: Code? = null,

    @SerializedName("Request")
    @Expose
    var request: RequestModel? = null,

    var sectionMode:String = "0"
)