package com.base.base_app.data.model.portfolio

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PortfolioParamsModel(
    @Expose @SerializedName("Personnel") var personnel: String,
    @Expose @SerializedName("FromDate") var fromDate: String,
    @Expose @SerializedName("ToDate") var toDate: String,
    @Expose @SerializedName("RegistrationDate")  private val registrationDate: String,
    @Expose @SerializedName("Description") var description: String
)