package com.base.base_app.data.model.message

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MessageModel (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Title")
    @Expose
    var title: String? = null,

    @SerializedName("Body")
    @Expose
    var body: String? = null,

    @SerializedName("Receivers")
    @Expose
    var receivers: List<Receiver>? = null,

    @SerializedName("Sender")
    @Expose
    var sender: Sender? = null,

    @SerializedName("Template")
    @Expose
    var template: Any? = null,

    @SerializedName("Type")
    @Expose
    var type: Type? = null,

    @SerializedName("RegistrationDate")
    @Expose
    var registrationDate: String? = null,

    @SerializedName("SendDate")
    @Expose
    var sendDate: String? = null,

    @SerializedName("Culture")
    @Expose
    var culture: String? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: Any? = null
)