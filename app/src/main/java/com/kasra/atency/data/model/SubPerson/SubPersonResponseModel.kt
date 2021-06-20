package com.kasra.atency.data.model.SubPerson

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kasra.atency.data.model.performance.day.Code
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "personnel_table")
data class SubPersonResponseModel (
    @PrimaryKey
    @SerializedName("Id")
    @Expose
    var id: String,

    @SerializedName("PersonnelCode")
    @Expose
    var personnelCode: String? = null,

    @SerializedName("FirstName")
    @Expose
    var firstName: String? = null,

    @SerializedName("LastName")
    @Expose
    var lastName: String? = null,

    @SerializedName("Code")
    @Expose
    var code: Code? = null,

    @SerializedName("AtendanceLogTime")
    @Expose
    var attendanceLogTime: String? = null,

    @SerializedName("ImageName")
    @Expose
    var imageName: String? = null,

    @SerializedName("ImageUrl")
    @Expose
    var imageUrl: String? = null,

    @SerializedName("IsDefaultAvatar")
    @Expose
    var isDefaultAvatar:Boolean = false,

    @SerializedName("Workplace")
    @Expose
    var workPlace: WorkplaceModel? = null
)