package com.base.base_app.data.repository

import com.base.base_app.data.model.Info.CellInfoModel
import com.base.base_app.data.model.LoginResponse
import com.base.base_app.data.model.UserInfo
import com.base.base_app.data.model.health.HealthCheckModel
import com.base.base_app.data.model.message.MessageModel
import com.base.base_app.data.model.request.MyRequestsModel
import com.base.base_app.utility.CustomResponse
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun healthCheck(isMain: Boolean): Flow<CustomResponse<HealthCheckModel?>>
    suspend fun loginPostRequest(
        grantType: String?,
        userName: String?,
        password: String?,
        clientId: String?
    ): Flow<CustomResponse<LoginResponse?>>

    suspend fun logoutCall(cellInfoModel: CellInfoModel?): Flow<CustomResponse<JsonObject?>>
    suspend fun getUserInfo(): Flow<CustomResponse<UserInfo?>>
    suspend fun getBadgeMessage(): Flow<CustomResponse<JsonObject?>>
    suspend fun getAllMessages(
        personelId: Int,
        from: Int,
        size: Int,
        searchedText: String?
    ): Flow<CustomResponse<List<MessageModel?>?>>

    suspend fun getAllRequestTypes(): Any
    suspend fun getMyRequests(
        fromDate: String?,
        toDate: String?,
        personnelId: String?
    ): Flow<CustomResponse<List<MyRequestsModel>>>
}