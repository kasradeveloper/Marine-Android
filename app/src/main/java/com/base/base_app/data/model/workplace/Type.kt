package com.base.base_app.data.model.workplace

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Type (
    @SerializedName("Id")
    @Expose
    private var id:Int = 0,

    @SerializedName("LookupCategory")
    @Expose
    var lookupCategory: Any? = null,

    @SerializedName("Value")
    @Expose
    var value: String,

    @SerializedName("Name")
    @Expose
    var name: Any? = null,

    @SerializedName("Description")
    @Expose
    var description: Any? = null,

    @SerializedName("OrderIndex")
    @Expose
    var orderIndex: Int? = null


)