package com.base.base_app.data

import com.base.base_app.data.model.*
import com.base.base_app.utility.CustomResponse
import com.base.bime.data.model.ConstructionDate
import com.base.bime.data.model.LoginModel
import com.base.base_app.data.model.Obligation
import com.google.gson.JsonObject
import org.json.JSONObject

interface AppDataManager {
    suspend fun loginApiCall(phoneNumber:String, password:String): CustomResponse<LoginModel>
    fun saveToken(token:String)
    fun saveRefreshToken(refreshToken:String)
    suspend fun loginOrRegister(phoneNumber:String): CustomResponse<JSONObject>
    suspend fun getVehicleModel(insurancePolicyTypeId:String,usageId:String,companyId:String):CustomResponse<List<BaseModel>>
    suspend fun getVehicleCompany(insurancePolicyTypeId:String,usageId:String):CustomResponse<List<BaseModel>>
    suspend fun getVehicleUsage(insurancePolicyTypeId:String):CustomResponse<List<BaseModel>>
    fun getIslogined():Boolean
    suspend fun getVehicleInsurancePolicy():CustomResponse<List<BaseModel>>
    suspend fun getConstructionDate() :CustomResponse<List<ConstructionDate>>
    suspend fun getVehicleInsuranceCompany():CustomResponse<List<BaseModel>>
    fun getToken() :String
    suspend fun addInquiry(vehicle: Vehicle): CustomResponse<JsonObject>

    //    : CustomResponse<JSONObject>
    suspend fun updateInquiryVehicle(vehicle: Vehicle): CustomResponse<JsonObject>
    suspend fun updateInquiryLastInsurancePolicy(inquiryModel: InquiryModel): CustomResponse<JsonObject>
    suspend fun updateInquiryLosses(inquiryModel: InquiryModel): CustomResponse<JsonObject>
    suspend fun paymentMethods(): CustomResponse<List<Obligation>>
    suspend fun updateInquiryPaymentMethodInsuranceCompany(updatePaymentMehod: UpdatePaymentMehod): CustomResponse<List<Obligation>>
}