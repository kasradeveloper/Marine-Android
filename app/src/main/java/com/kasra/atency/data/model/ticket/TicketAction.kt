package com.kasra.atency.data.model.ticket

import com.kasra.atency.data.model.message.User
import com.kasra.atency.data.model.workplace.Type
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TicketAction(
    @Expose @SerializedName("Value") var value: String,
    @Expose @SerializedName("RegisteredOn") var registeredOn: String,
    @SerializedName("Ticket")
    @Expose
    var ticket: TicketItem? = null,

    @SerializedName("TrackingCode")
    @Expose
    var trackingCode: String? = null,

    @SerializedName("Type")
    @Expose
    var actionType: Type? = null,

    @SerializedName("Owner")
    @Expose
    var owner: User? = null,

    @SerializedName("RegisteredBy")
    @Expose
    var registeredBy: User? = null,

    @SerializedName("ModifiedBy")
    @Expose
    var modifiedBy: User? = null,

    @SerializedName("ModifiedOn")
    @Expose
    var modifiedOn: String? = null,

    @SerializedName("IsHeader")
    @Expose
    var isHeader: Boolean = false

)