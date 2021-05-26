package com.base.base_app.data.model.performance.day

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DaySection (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("SectionItems")
    @Expose
    var sectionItems: List<SectionItem>? = null
)