package com.kasra.atency.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Yamin on 7/18/2018.
 */
data class CredentialToken(
    @field:Expose @field:SerializedName("access_token") var accessToken: String,
    @field:Expose @field:SerializedName(
        "token_type"
    ) var tokenType: String,
    @field:Expose @field:SerializedName("expires_in") var expiresIn: String,
    @field:Expose @field:SerializedName(
        "refresh_token"
    ) var refrshToken: String
)