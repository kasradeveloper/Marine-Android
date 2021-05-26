package com.base.base_app.data.model.logout

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogoutParams(@field:Expose @field:SerializedName("logoutDate") var logoutDate: String)