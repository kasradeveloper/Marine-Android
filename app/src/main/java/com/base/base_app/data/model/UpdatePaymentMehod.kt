package com.base.base_app.data.model

import com.squareup.moshi.Json

data class UpdatePaymentMehod(
    @Json(name = "paymentMethodInsuranceCompany")
    val paymentMethodInsuranceCompany:String,
    @Json(name = "isCashPaymentType")
    val isCashPaymentType:Boolean
)
