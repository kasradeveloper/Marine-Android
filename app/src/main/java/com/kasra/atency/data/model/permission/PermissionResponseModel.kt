package com.kasra.atency.data.model.permission

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "permission")
data class PermissionResponseModel(@field:Expose @field:SerializedName("Id") @field:PrimaryKey var id: Int)
