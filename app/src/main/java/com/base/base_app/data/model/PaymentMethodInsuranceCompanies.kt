package com.base.base_app.data.model

import com.base.bime.data.model.InsuranceCompany
import com.squareup.moshi.Json

data class PaymentMethodInsuranceCompanies(
    @Json(name = "insuranceCompany")
    val insuranceCompany: InsuranceCompany,
    @Json(name = "hasCashPaymentType")
    val hasCashPaymentType:Boolean,
    @Json(name = "hasInstallmentPaymentType")
    val hasInstallmentPaymentType:Boolean


)
