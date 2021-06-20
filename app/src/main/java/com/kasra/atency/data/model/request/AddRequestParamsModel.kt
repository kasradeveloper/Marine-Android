package com.kasra.atency.data.model.request

import com.kasra.atency.data.model.SubPerson.SubPersonParamsModel
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddRequestParamsModel (
    @SerializedName("FromDate")
    @Expose
    var fromDate: String? = null,

    @SerializedName("ToDate")
    @Expose
    var toDate: String? = null,

    @SerializedName("Personnel")
    @Expose
    var personnel: SubPersonParamsModel? = null,

    @SerializedName("Description")
    @Expose
    var description: String? = null,

    @SerializedName("RequestType")
    @Expose
    var requestType: RequestTypeAdd? = null,

    @SerializedName("MetaData")
    @Expose
    var metaData: String? = null,

    @SerializedName("Workplace")
    @Expose
    var workplace: WorkplaceModel? = null
)