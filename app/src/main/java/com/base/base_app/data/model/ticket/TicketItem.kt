package com.base.base_app.data.model.ticket

import com.base.base_app.data.model.attendance.Tenant
import com.base.base_app.data.model.message.User
import com.base.base_app.data.model.workplace.Type
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TicketItem (
    @SerializedName("Id")
    @Expose
    var id: String? = null,

    @SerializedName("TrackingCode")
    @Expose
    var trackingCode: String? = null,

    @SerializedName("Title")
    @Expose
    var title: String? = null,

    @SerializedName("Priority")
    @Expose
    var priority: Type? = null,

    @SerializedName("Category")
    @Expose
    var category: Type? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: Tenant? = null,

    @SerializedName("LastStatus")
    @Expose
    var lastStatus: Type? = null,

    @SerializedName("RegisteredBy")
    @Expose
    var registeredBy: User? = null,

    @SerializedName("RegisteredOn")
    @Expose
    var registeredOn: String? = null,

    @SerializedName("ModifiedBy")
    @Expose
    var modifiedBy: User? = null,

    @SerializedName("LastModifiedDate")
    @Expose
    var modifiedOn: String? = null,

    @SerializedName("Actions")
    @Expose
    var ticketActions: List<TicketAction>? = null

)