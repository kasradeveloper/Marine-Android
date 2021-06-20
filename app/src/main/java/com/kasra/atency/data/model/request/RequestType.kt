package com.kasra.atency.data.model.request

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "request_Types_table")
data class RequestType (
    @PrimaryKey
    @SerializedName("ID")
    @Expose
    var iD: Int ,
    @SerializedName("Code")
    @Expose
    var code: String? = null,

    @SerializedName("Title")
    @Expose
    var title: String? = null,

    @SerializedName("Acronym")
    @Expose
    var acronym: Any? = null,

    @SerializedName("RequestClass")
    @Expose
    var requestClass: RequestClass? = null,

    @SerializedName("RequestGroup")
    @Expose
    var requestGroup: RequestGroup? = null,

    @SerializedName("Color")
    @Expose
    var color: String? = null
)