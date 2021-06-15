package com.base.base_app.data.model.ticket

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AddActionResponse {
    @SerializedName("Data")
    @Expose
    var ticketItem: TicketItem? = null
}