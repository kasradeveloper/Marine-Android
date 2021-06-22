package com.kasra.atency.data.network

import com.google.gson.JsonObject
import com.kasra.atency.data.model.CredentialToken
import com.kasra.atency.data.model.Info.CellInfoModel
import com.kasra.atency.data.model.LoginResponse
import com.kasra.atency.data.model.SubPerson.SubPersonResponseModel
import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.attendance.AttendanceLogResponseModel
import com.kasra.atency.data.model.checkinout.AttLogModel
import com.kasra.atency.data.model.checkinout.AttLogResponseModel
import com.kasra.atency.data.model.credit.CreditParams
import com.kasra.atency.data.model.credit.ResponseApprove
import com.kasra.atency.data.model.credit.ResponseDeny
import com.kasra.atency.data.model.health.HealthCheckModel
import com.kasra.atency.data.model.message.MessageModel
import com.kasra.atency.data.model.paired.PairedAttendanceListResponseModel
import com.kasra.atency.data.model.performance.day.DayTimelineResponseModel
import com.kasra.atency.data.model.performance.summary.PerformanceSummaryReportResponseModel
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.model.portfolio.PortfolioResponseModel
import com.kasra.atency.data.model.request.AddRequestParamsModel
import com.kasra.atency.data.model.request.MyRequestsModel
import com.kasra.atency.data.model.request.RequestType
import com.kasra.atency.data.model.ticket.TicketAction
import com.kasra.atency.data.model.ticket.TicketItem
import com.kasra.atency.data.model.update.CheckUpdateResponseModel
import com.kasra.atency.data.model.workperiod.GetAllWorkperiods
import com.kasra.atency.data.model.workplace.OsmSearch
import com.kasra.atency.data.model.workplace.Type
import com.kasra.atency.data.model.workplace.WorkplaceModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface ApiServices {
    @FormUrlEncoded
    @POST("connect/token")
    suspend fun refreshToken(
        @Field("grant_type") grantType: String?,
        @Field("refresh_token") refreshToken: String?,
        @Field("client_id") clientID: String?
    ): Response<CredentialToken>

    @FormUrlEncoded
    @POST("connect/token")
    suspend fun loginPostRequest(
        @Field("grant_type") grantType: String?,
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("client_id") clientId: String?
    ): Response<LoginResponse>

    @GET("connect/userinfo")
    suspend fun getUserInfo(): Response<UserInfo>

    @GET("api/HealthCheckApi/CheckHealth")
    suspend fun healthCheck(): Response<HealthCheckModel>

    @GET("api/ProfileAPI/GetPersonnelProfilePictureNameLess")
    suspend fun getProfilePicture(): Response<ResponseBody>

    @GET("api/CustomerMessageAPI/GetAllCustomerMessages")
    suspend fun getAllMessages(
        @Query("personnelId") personnelId: Int,
        @Query("from") from: Int,
        @Query("size") size: Int,
        @Query("searchValue") searchedText: String?
    ): Response<List<MessageModel>>

    @GET("api/WorkperiodAPI/GetAllWorkperiods")
    suspend fun getWorkPeriod(
        @Query("today") Date: String?
    ): Response<GetAllWorkperiods>

    @GET("api/WorkplaceAPI/GetMyWorkplaces")
    suspend fun getWorkplaces(
        @Query("workplaceTypeValue") workplaceType: Int
    ): Response<List<WorkplaceModel>>

    @GET("API/RequestApi/GetAllRequestTypes")
    suspend fun getAllRequestTypes(): Response<List<RequestType>>

    @POST("api/AttendanceLogAPI/AddAttendanceLog")
    suspend fun attLogPostRequest(
        @Body attLogModel: AttLogModel?
    ): Response<AttLogResponseModel>

    @GET("api/PerformanceAuditAPI/GetPerformanceSummaryReport")
    suspend fun getMonthlyPerformance(

        @Query("startDate") startDate: String?,
        @Query("enddate") endDate: String?,
        @Query("personnelId") personnelId: Int,
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<PerformanceSummaryReportResponseModel>

    @GET("api/PermissionAPI/GetPermissions")
    suspend fun getPermissions(
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<List<PermissionResponseModel>>


    @GET("/api/CustomerMessageAPI/GetUnreadCustomerMessageCount")
    suspend fun getBadgeMessage(): Response<JsonObject>

    @GET("api/PersonnelAPI/GetSubordinates")
    suspend fun getSubPerson(

        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<List<SubPersonResponseModel>>

    @GET("api/PerformanceAuditAPI/GetPerformanceDayTimeline")
    suspend fun getDayTimeline(
        @Query("personnelId") personnelId: Int,
        @Query("date") date: String?,
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<DayTimelineResponseModel>

    @POST("API/RequestApi/ApproveRequest")
    suspend fun approveRequest(
        @Body requestApprove: CreditParams?
    ): Response<ResponseApprove>

    @POST("API/RequestApi/DenyRequest")
    suspend fun denyRequest(
        @Body requestApprove: CreditParams?
    ): Response<ResponseDeny>

    @POST("API/RequestApi/DeleteRequest")
    suspend fun deleteRequest(
        @Body requestApprove: CreditParams?
    ): Response<ResponseDeny>

    @POST("API/RequestApi/AddRequest")
    suspend fun addRequest(
        @Body addRequestParamsModel: AddRequestParamsModel?
    ): Response<ResponseDeny>

    @POST("API/WorkplaceAPI/UpdateWorkplace")
    suspend fun updateWorkplace(
        @Body workplaceModel: WorkplaceModel?
    ): Response<WorkplaceModel>

    @POST("API/WorkplaceAPI/AddWorkplace")
    suspend fun addWorkplace(
        @Body workplaceModel: WorkplaceModel?
    ): Response<WorkplaceModel>

    @POST("API/WorkplaceAPI/DeleteWorkplace")
    suspend fun deleteWorkplace(
        @Body workplaceModel: WorkplaceModel?
    ): Response<WorkplaceModel>

    @GET("api/AttendanceLogAPI/GetPairedAttendanceLogs")
    suspend fun getPairedAttendanceLogs(

        @Query("personnelId") personnelId: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("attendanceTypeValue") attendanceTypeValue: String?
    ): Response<List<PairedAttendanceListResponseModel>>

    @GET("API/RequestApi/GetMyRequests")
    suspend fun getMyRequests(

        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("personnelId") personnelId: String?
    ): Response<List<MyRequestsModel>>

    @GET("API/RequestApi/GetPersonnelPendingRequests")
    suspend fun getportfolioItems(
        @Query("personnelId") personnelId: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("description") description: String?
    ): Response<List<PortfolioResponseModel>>

    @GET("api/AttendanceLogAPI/GetAttendanceLogs")
    suspend fun getAttendanceLogs(
        @Query("personnelId") personnelId: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("attendanceTypeValue") attendanceTypeValue: String?
    ): Response<List<AttendanceLogResponseModel>>

    @POST("api/UserAPI/UpdateUserCellPhoneInfo")
    suspend fun updateCellInfo(
        @Body cellInfoModel: CellInfoModel?
    ): Response<JsonObject>

    @POST("api/UserAPI/UpdateUserCellPhoneInfo")
    suspend fun logoutCall(
        @Body cellInfoModel: CellInfoModel?
    ): Response<JsonObject>

    @FormUrlEncoded
    @POST("api/CustomerMessageAPI/UpdateCustomerMessageStatus")
    suspend fun updateStatusCall(
        @Field("messageId") messageId: String?,
        @Field("messageStatusValue") messageStatusValue: String?,
        @Field("modificationDate") modificationDate: String?
    ): Response<JsonObject>

    @GET("api/VersionAPI/CheckForUpdate")
    suspend fun checkForUpdate(
        @Query("platformValue") platformValue: String?,
        @Query("version") version: String?
    ): Response<CheckUpdateResponseModel>

    @GET("api/ProfileAPI/GetPersonnelProfilePictureNameLess")
    suspend fun checkImageFile(@Header("Authorization") accessToken: String?): Response<ResponseBody>

    @POST("api/PersonnelAPI/UploadImage")
    suspend fun uploadImage(

        @Query("pathEnumValue") one: Int?,
        @Body file: RequestBody?
    ): Response<JsonObject>

    @GET
    suspend fun getOSMSearch(@Url url: String?): Response<List<OsmSearch>>

    @GET("api/TicketApi/GetTicketCategoryTypes")
    suspend fun getTicketCategoryTypes(): Response<List<Type>>

    @GET("api/TicketApi/GetTicketPriorityTypes")
    suspend fun getTicketPriorityTypes(): Response<List<Type>>

    @POST("api/TicketAPI/AddTicket")
    suspend fun addTicket(
        @Body item: TicketItem?
    ): Response<JsonObject>

    @GET("api/TicketAPI/GetTickets")
    suspend fun getTicket(
        @Query("searchValue") searchValue: String?,
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int
    ): Response<List<TicketItem>>

    @GET("api/TicketAPI/GetTicketActions")
    suspend fun getTicketAction(
        @Query("ticketId") ticketId: String?,
        @Query("actionTypeValue") actionTypeValue: String?
    ): Response<List<TicketAction>>

    @POST("api/TicketAPI/AddTicketMessage")
    suspend fun addTicketAction(
        @Body action: TicketAction?
    ): Response<TicketItem>

}