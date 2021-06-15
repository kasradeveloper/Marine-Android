package com.base.base_app.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_info")
class UserInfo (
    @PrimaryKey
    @SerializedName("sub")
    @Expose
    var sub: String? = null,

    @SerializedName("address")
    @Expose
    var address: Address? = null,

    @SerializedName("given_name")
    @Expose
    var givenName: String? = null,

    @SerializedName("iss")
    @Expose
    var iss: String? = null,

    @SerializedName("website")
    @Expose
    var website: String? = null,

    @SerializedName("aud")
    @Expose
    var aud: String? = null,

    @SerializedName("preferred_username")
    @Expose
    var personnelId: String? = null


)