package com.kasra.atency.data.model.update

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Platform (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("LookupCategory")
    @Expose
    var lookupCategory: Any? = null,

    @SerializedName("Value")
    @Expose
    var value: String? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("Description")
    @Expose
    var description: Any? = null,

    @SerializedName("OrderIndex")
    @Expose
    var orderIndex: Int? = null,

    @SerializedName("Color")
    @Expose
    var color: Any? = null
)