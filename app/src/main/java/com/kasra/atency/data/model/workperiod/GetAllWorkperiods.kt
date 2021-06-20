package com.kasra.atency.data.model.workperiod

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import androidx.room.PrimaryKey

@Entity(tableName = "get_work_period")
data class GetAllWorkperiods (
    @SerializedName("Id")
    @Expose
    @PrimaryKey
    var id: Int ,

    @SerializedName("Workperiods")
    @Expose
    var workperiods: List<Workperiod>? = null,

    @SerializedName("CurrentWorkperiod")
    @Expose
    var currentWorkperiod: Workperiod? = null
)