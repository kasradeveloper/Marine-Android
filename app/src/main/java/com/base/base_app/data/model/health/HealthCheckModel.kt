package com.base.base_app.data.model.health

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HealthCheckModel (
    @SerializedName("main")
    @Expose
    var isMain:Boolean = false,

    @SerializedName("alternate")
    @Expose
    var isAlternative:Boolean = false
)