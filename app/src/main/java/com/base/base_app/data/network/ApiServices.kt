package com.base.base_app.data.network

import com.base.base_app.data.model.*
import com.base.bime.data.model.ConstructionDate
import com.base.bime.data.model.LoginModel
import com.base.base_app.data.model.Obligation
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*


interface ApiServices {
    @POST("api/user/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginModel>

    @POST("api/user/loginOrRegister/{phoneNumber}")
    suspend fun loginOrReisterUser(@Path("phoneNumber ") phoneNumber: String): Response<JSONObject>

    @GET("api/insurance/insurancePolicyTypes")
    suspend fun getVehicleInsurancePolicy(@Header("Authorization") accessToken: String): Response<List<BaseModel>>

    @GET("api/vehicle/usages/{id}")
    suspend fun getVehicleUsage(
        @Header("Authorization") accessToken: String,
        @Path("id") vehicleUsage: String
    ): Response<List<BaseModel>>

    @GET("api/vehicle/companies")
    suspend fun getVehicleCompany(
        @Header("Authorization") accessToken: String,
        @Query("insurancePolicyTypeId") insurancePolicyTypeId: String,
        @Query("usageId") usageId: String
    ): Response<List<BaseModel>>

    @GET("api/vehicle/models")
    suspend fun getVehicleModel(
        @Header("Authorization") accessToken: String,
        @Query("insurancePolicyTypeId") insurancePolicyTypeId: String,
        @Query("usageId") usageId: String,
        @Query("companyId") companyId: String
    ): Response<List<BaseModel>>

    @GET("api/vehicle/constructionDates")
    suspend fun getCunstructionDate(@Header("Authorization") accessToken: String): Response<List<ConstructionDate>>
    @GET("api/insurance/insuranceCompanies")
    suspend  fun getVehicleInsuranceCompanies(@Header("Authorization")accessToken:String):Response<List<BaseModel>>


    //  inquiry
    @Headers("Content-Type: application/json")
    @POST("api/thirdPartyInsurancePolicy/inquiry")
    suspend fun addInquiry(
        @Header("Authorization") accessToken: String,
        @Body vehicle: Vehicle
    ): Response<JsonObject>

    @POST("api/thirdPartyInsurancePolicy/updateInquiryVehicle/{id}")
    suspend fun updateInquiryVehicle(
        @Header("Authorization") accessToken: String,
        @Path("id") vehicleUsage: String,
        @Body vehicle: Vehicle
    ): Response<JsonObject>

    @POST("api/thirdPartyInsurancePolicy/updateInquiryLastInsurancePolicy/{id}")
    suspend fun updateInquiryLastInsurancePolicy(
        @Header("Authorization") accessToken: String,
        @Path("id") vehicleUsage: String,
        @Body inquiryModel: InquiryModel
    ): Response<JsonObject>

    @POST("api/thirdPartyInsurancePolicy/updateInquiryLosses/{id}")
    suspend fun updateInquiryLosses(
        @Header("Authorization") accessToken: String,
        @Path("id") vehicleUsage: String,
        @Body inquiryModel: InquiryModel
    ): Response<JsonObject>
    @GET("api/thirdPartyInsurancePolicy/paymentMethods/{id}")
    suspend fun paymentMethods(
        @Header("Authorization") accessToken: String,
        @Path("id") inquiryId: String
    ): Response<List<Obligation>>
    @GET("api/thirdPartyInsurancePolicy/updateInquiryPaymentMethodInsuranceCompany/{id}")
    suspend fun updateInquiryPaymentMethodInsuranceCompany(
        @Header("Authorization") accessToken: String,
        @Path("id") inquiryId: String,
        @Body updatePaymentMethod: UpdatePaymentMehod

    ): Response<List<Obligation>>

}