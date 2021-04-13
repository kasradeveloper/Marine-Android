package com.base.base_app.data.network


import com.base.base_app.data.model.InquiryModel
import com.base.base_app.data.model.LoginRequest
import com.base.base_app.data.model.UpdatePaymentMehod
import com.base.base_app.data.model.Vehicle
import com.base.base_app.data.network.ApiHelper
import com.base.base_app.data.network.ApiServices
import com.base.base_app.data.network.BaseRequest
import com.base.bime.data.model.*
import com.base.base_app.utility.CustomResponse
import javax.inject.Inject


class ApiHelperImpl @Inject constructor(private val services: ApiServices) : ApiHelper,
    BaseRequest() {
    override suspend fun loginUser(phoneNumber:String, password:String): CustomResponse<LoginModel> {
        val loginRequest = LoginRequest("9134328684", "Abc1234@\$")
        return getResult { services.loginUser(loginRequest) }
    }
    override suspend fun funLoginOrRegister(phoneNumber:String)=getResult{services.loginOrReisterUser(phoneNumber)}
    override suspend fun getVehicleInsurancePolicy(accessToken:String)=getResult{services.getVehicleInsurancePolicy(accessToken)}
    override suspend fun getVehicleUsage(accessToken:String,id:String)=getResult{services.getVehicleUsage(accessToken,id)}
    override suspend fun getVehicleCompany(accessToken:String,insurancePolicyTypeId:String,usageId:String)=getResult{services.getVehicleCompany(accessToken,insurancePolicyTypeId,usageId)}
    override suspend fun getVehicleModel(accessToken:String,insurancePolicyTypeId:String,usageId:String,companyId:String)=getResult{services.getVehicleModel(accessToken,insurancePolicyTypeId,usageId,companyId)}
    override suspend fun getConstructionDateModel(accessToken:String)=getResult{services.getCunstructionDate(accessToken)}
    override suspend fun getVehicleCompanieInsurancePolicy(accessToken:String)=getResult{services.getVehicleInsuranceCompanies(accessToken)}
    override suspend fun addInquiry(accessToken:String,vehicle: Vehicle)=getResult{services.addInquiry(accessToken,
        vehicle)}
    override suspend fun updateInquiryVehicle(accessToken:String,inquiryId:String,vehicle: Vehicle)=getResult{services.updateInquiryVehicle(accessToken,inquiryId,vehicle)}
    override suspend fun updateInquiryLastInsurancePolicy(accessToken:String,inquiryId:String,inquiryModel: InquiryModel)=getResult{services.updateInquiryLastInsurancePolicy(accessToken,inquiryId,inquiryModel)}
    override suspend fun updateInquiryLosses(accessToken:String,inquiryId:String,inquiryModel: InquiryModel)=getResult{services.updateInquiryLosses(accessToken,inquiryId,inquiryModel)}
    override suspend fun paymentMethods(accessToken:String,inquiryId:String)=getResult{services.paymentMethods(accessToken,inquiryId)}
    override suspend fun updateInquiryPaymentMethodInsuranceCompany(accessToken:String,inquiryId:String,updatePaymentMehod: UpdatePaymentMehod)=getResult{services.updateInquiryPaymentMethodInsuranceCompany(accessToken,inquiryId,updatePaymentMehod)}



}