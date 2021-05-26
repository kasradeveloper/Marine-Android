package com.base.base_app.data.model.checkinout

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AttendanceType(
    @SerializedName("Value")
    @Expose
    private var value: String? = null
)
