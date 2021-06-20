package com.kasra.atency.data.model.workperiod

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Workperiod (
    @SerializedName("IsCurrentWorkperiod")
    @Expose
    var isCurrentWorkperiod: Boolean? = null,

    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("StartDate")
    @Expose
    var startDate: String? = null,

    @SerializedName("EndDate")
    @Expose
    var endDate: String? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("OrderIndex")
    @Expose
    var orderIndex: Int? = null,

    @SerializedName("IsLock")
    @Expose
    var isLock:Boolean = false,
    var isSelected:Boolean = false
)