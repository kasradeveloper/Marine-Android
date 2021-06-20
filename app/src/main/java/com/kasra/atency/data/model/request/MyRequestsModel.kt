package com.kasra.atency.data.model.request

import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MyRequestsModel
    (
    @SerializedName("ID")
    @Expose
    var iD: Int? = null,

    @SerializedName("FromDate")
    @Expose
    var fromDate: String? = null,

    @SerializedName("ToDate")
    @Expose
    var toDate: String? = null,

    @SerializedName("Applicant")
    @Expose
    var applicant: ApplicantModel? = null,

    @SerializedName("Approver")
    @Expose
    var approver: Any? = null,

    @SerializedName("Description")
    @Expose
    var description: String? = null,

    @SerializedName("LastRequestStatus")
    @Expose
    var lastRequestStatus: LastRequestStatus? = null,

    @SerializedName("Tenant")
    @Expose
    var tenant: TenantModel? = null,

    @SerializedName("RegistrationDate")
    @Expose
    var registrationDate: String? = null,

    @SerializedName("MetaData")
    @Expose
    var metaData: String? = null,

    @SerializedName("RegistrationDateText")
    @Expose
    var registrationDateText: Any? = null,

    @SerializedName("RequestType")
    @Expose
    var requestType: RequestType? = null,

    @SerializedName("Deletable")
    @Expose
    var deletable: Boolean? = null,

    @SerializedName("FromToDate")
    @Expose
    var fromToDate: Any? = null,

    @SerializedName("FromToTimes")
    @Expose
    var fromToTimes: Any? = null,

    @SerializedName("Workplace")
    @Expose
    var workplace: WorkplaceModel? = null,

    @SerializedName("CurrentRequestStatus")
    @Expose
    var currentRequestStatus: CurrentRequestStatus? = null
)