package com.base.base_app.data.model

import com.squareup.moshi.Json

data class InquiryModel(
    @Json(name = "_id")
    var _id:String?=null,
    @Json(name = "vehicle")
    var vehicle:String?=null,
    @Json(name = "driverDiscount")
    var driverDiscount:Double=0.0,
    @Json(name = "insurancePolicyDiscount")
    var insurancePolicyDiscount:Double=0.0,
    @Json(name = "latestInsuranceCompany")
    var latestInsuranceCompany:String?=null,
    @Json(name = "latestInsurancePolicyEndDate")
    var latestInsurancePolicyEndDate:String?=null,
    @Json(name = "latestInsurancePolicyStartDate")
    var latestInsurancePolicyStartDate:String?=null,
    @Json(name = "driverLosses")
    var driverLosses:Int=0,
    @Json(name = "financialLosses")
    var financialLosses:Int=0,
    @Json(name = "lifeLosses")
    var lifeLosses:Int=0,
)
