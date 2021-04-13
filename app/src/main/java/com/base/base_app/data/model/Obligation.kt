package com.base.base_app.data.model

import android.system.Int64Ref
import com.base.base_app.data.model.PaymentMethodInsuranceCompanies
import com.squareup.moshi.Json

data class Obligation(
    @Json(name = "obligationAmount")
    val obligationAmount:String,
    @Json(name = "paymentMethodInsuranceCompanies")
    val paymentMethodInsuranceCompanies:List<PaymentMethodInsuranceCompanies>,
    var selected:Boolean=false

)
