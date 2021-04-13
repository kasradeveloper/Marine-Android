package com.base.base_app.data


import com.base.base_app.data.model.InquiryModel
import com.base.base_app.data.model.UpdatePaymentMehod
import com.base.base_app.data.model.Vehicle
import com.base.base_app.data.network.ApiHelper

import com.base.base_app.utility.CustomResponse
import com.base.base_app.data.prefrences.AppPrefrencesHelper
import com.base.bime.data.model.LoginModel
import com.base.bime.data.room.DataBaseHelper
import com.google.gson.JsonObject
import javax.inject.Inject

class AppDataManagerImpl @Inject constructor(
    private val dataBaseHelper: DataBaseHelper,
    private val prefrencesHelper: AppPrefrencesHelper,
    private val apiHelper: ApiHelper
) :
    AppDataManager {

    override suspend fun loginApiCall(
        phoneNumber: String,
        password: String
    ): CustomResponse<LoginModel> {
        val loginResponse = apiHelper.loginUser(phoneNumber, password)
        if (loginResponse.status == CustomResponse.Status.SUCCESS) {
            saveToken(loginResponse.data?.access_token.toString())
            saveRefreshToken(loginResponse.data?.refresh_token.toString())
            prefrencesHelper.setIsLogin(true)
        }
        return loginResponse
    }


    // save token to shared prefrences
    override fun saveToken(token: String) {
        prefrencesHelper.setAceesToken(token)
    }

    override fun getToken(): String {
        return prefrencesHelper.getAccessToken()!!
    }


    // save refresh token to share prefrences
    override fun saveRefreshToken(refreshToken: String) {
        prefrencesHelper.setRefreshToken(refreshToken)
    }

    //api for getting code from message
    override suspend fun loginOrRegister(phoneNumber: String) =
        apiHelper.funLoginOrRegister(phoneNumber)

    override suspend fun getVehicleInsurancePolicy() = apiHelper.getVehicleInsurancePolicy(
        "Bearer " + prefrencesHelper.getAccessToken().toString()
    )

    override suspend fun getVehicleUsage(insurancePolicyTypeId: String) = apiHelper.getVehicleUsage(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        insurancePolicyTypeId
    )

    override fun getIslogined(): Boolean = prefrencesHelper.getIsLogin()!!


    override suspend fun getVehicleCompany(insurancePolicyTypeId: String, usageId: String) =
        apiHelper.getVehicleCompany(
            "Bearer " + prefrencesHelper.getAccessToken().toString(),
            insurancePolicyTypeId,
            usageId
        )

    override suspend fun getVehicleInsuranceCompany() =
        apiHelper.getVehicleCompanieInsurancePolicy(
            "Bearer " + prefrencesHelper.getAccessToken().toString()
        )

    override suspend fun getVehicleModel(
        insurancePolicyTypeId: String,
        usageId: String,
        companyId: String
    ) = apiHelper.getVehicleModel(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        insurancePolicyTypeId,
        usageId,
        companyId
    )

    override suspend fun getConstructionDate() = apiHelper.getConstructionDateModel(
        "Bearer " + prefrencesHelper.getAccessToken().toString()
    )

    override suspend fun addInquiry(
        vehicle: Vehicle
    )
    : CustomResponse<JsonObject>
    {
        val response=apiHelper.addInquiry(
            "Bearer " + prefrencesHelper.getAccessToken().toString(),
            vehicle
        )
        if(response.status==CustomResponse.Status.SUCCESS) {
            response.data?.let { prefrencesHelper.setInquiryId(it.get("_id").asString) }
        }
        return response
    }
    override suspend fun updateInquiryVehicle(
        vehicle: Vehicle
    ) = apiHelper.updateInquiryVehicle(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        prefrencesHelper.getInquiryId()!!,
        vehicle
    )
    override suspend fun updateInquiryLastInsurancePolicy(
        inquiryModel: InquiryModel
    ) = apiHelper.updateInquiryLastInsurancePolicy(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        prefrencesHelper.getInquiryId()!!,
        inquiryModel
    )
    override suspend fun updateInquiryLosses(
        inquiryModel: InquiryModel
    ) = apiHelper.updateInquiryLosses(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        prefrencesHelper.getInquiryId()!!,
        inquiryModel
    )
    override suspend fun paymentMethods() = apiHelper.paymentMethods(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        prefrencesHelper.getInquiryId()!!,
    )
    override suspend fun updateInquiryPaymentMethodInsuranceCompany(updatePaymentMehod: UpdatePaymentMehod) = apiHelper.updateInquiryPaymentMethodInsuranceCompany(
        "Bearer " + prefrencesHelper.getAccessToken().toString(),
        prefrencesHelper.getInquiryId()!!,
        updatePaymentMehod
    )

    fun clearAllThing() = prefrencesHelper.clearAllThing()
}