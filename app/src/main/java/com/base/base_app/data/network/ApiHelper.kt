package com.base.base_app.data.network

import com.base.base_app.data.model.*
import com.base.bime.data.model.*
import com.base.base_app.utility.CustomResponse
import com.google.gson.JsonObject
import org.json.JSONObject

interface ApiHelper  {
     suspend fun loginUser(phoneNumber:String, password:String): CustomResponse<LoginModel>
     suspend fun funLoginOrRegister(phoneNumber:String): CustomResponse<JSONObject>
     suspend fun getVehicleInsurancePolicy(accessToken:String): CustomResponse<List<BaseModel>>
     suspend fun getVehicleUsage(accessToken:String,id:String): CustomResponse<List<BaseModel>>
     suspend fun getVehicleCompany(accessToken:String,insurancePolicyTypeId:String,usageId:String): CustomResponse<List<BaseModel>>
     suspend fun getVehicleModel(accessToken:String,insurancePolicyTypeId:String,usageId:String,companyId:String): CustomResponse<List<BaseModel>>
     suspend fun getConstructionDateModel(accessToken:String): CustomResponse<List<ConstructionDate>>
     suspend fun getVehicleCompanieInsurancePolicy(accessToken:String): CustomResponse<List<BaseModel>>
    suspend fun addInquiry(accessToken: String, vehicle: Vehicle): CustomResponse<JsonObject>
    suspend fun updateInquiryVehicle(
        accessToken: String,
        inquiryId: String,
        vehicle: Vehicle
    ): CustomResponse<JsonObject>

    suspend fun updateInquiryLastInsurancePolicy(
        accessToken: String,
        inquiryId: String,
        inquiryModel: InquiryModel
    ): CustomResponse<JsonObject>

    suspend fun updateInquiryLosses(
        accessToken: String,
        inquiryId: String,
        inquiryModel: InquiryModel
    ): CustomResponse<JsonObject>

    suspend fun paymentMethods(
        accessToken: String,
        inquiryId: String
    ): CustomResponse<List<Obligation>>

    suspend fun updateInquiryPaymentMethodInsuranceCompany(
        accessToken: String,
        inquiryId: String,
        updatePaymentMehod: UpdatePaymentMehod
    ): CustomResponse<List<Obligation>>
}