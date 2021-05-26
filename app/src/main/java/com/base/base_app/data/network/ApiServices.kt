package com.base.base_app.data.network

import com.base.base_app.data.model.*
import com.google.gson.JsonObject
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiServices {
    @FormUrlEncoded
    @POST("connect/token")
    fun refreshToken(
        @Field("grant_type") grantType: String?,
        @Field("refresh_token") refreshToken: String?,
        @Field("client_id") clientID: String?
    ): Response<CredentialToken?>?

    @FormUrlEncoded
    @POST("connect/token")
    fun loginPostRequest(
        @Field("grant_type") grantType: String?,
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("client_id") clientId: String?
    ): Response<LoginResponse?>?

    @GET("connect/userinfo")
    fun getUserInfo(@Header("Authorization") token: String?): Response<UserInfo?>?

    @GET("api/HealthCheckApi/CheckHealth")
    fun healthCheck(): Response<HealthCheckModel?>?

    @GET("api/ProfileAPI/GetPersonnelProfilePictureNameLess")
    fun getProfilePicture(@Header("Authorization") token: String?): Response<ResponseBody?>?

    @GET("api/CustomerMessageAPI/GetAllCustomerMessages")
    fun getAllMessages(
        @Header("Authorization") token: String?,
        @Query("personnelId") personnelId: Int,
        @Query("from") from: Int,
        @Query("size") size: Int,
        @Query("searchValue") searchedText: String?
    ): Response<List<MessageModel?>?>?

    @GET("api/WorkperiodAPI/GetAllWorkperiods")
    fun getWorkPeriod(
        @Header("Authorization") token: String?,
        @Query("today") Date: String?
    ): Response<GetAllWorkperiods?>?

    @GET("api/WorkplaceAPI/GetMyWorkplaces")
    fun getWorkplaces(
        @Header("Authorization") token: String?,
        @Query("workplaceTypeValue") workplaceType: Int
    ): Response<List<WorkplaceModel?>?>?

    @GET("API/RequestApi/GetAllRequestTypes")
    fun getAllRequestTypes(@Header("Authorization") token: String?): Response<List<RequestType?>?>?

    @POST("api/AttendanceLogAPI/AddAttendanceLog")
    fun attLogPostRequest(
        @Header("Authorization") accessToken: String?,
        @Body attLogModel: AttLogModel?
    ): Response<AttLogResponseModel?>?

    @GET("api/PerformanceAuditAPI/GetPerformanceSummaryReport")
    fun getMonthlyPerformance(
        @Header("Authorization") accessToken: String?,
        @Query("startDate") startDate: String?,
        @Query("enddate") endDate: String?,
        @Query("personnelId") personnelId: Int,
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<PerformanceSummaryReportResponseModel?>?

    @GET("api/PermissionAPI/GetPermissions")
    fun getPermissions(
        @Header("Authorization") accessToken: String?,
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<List<PermissionResponseModel?>?>?


    @GET("/api/CustomerMessageAPI/GetUnreadCustomerMessageCount")
    fun getBadgeMessage(@Header("Authorization") accessToken: String?): Response<JsonObject?>?

    @GET("api/PersonnelAPI/GetSubordinates")
    fun getSubPerson(
        @Header("Authorization") accessToken: String?,
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<List<SubPersonResponseModel?>?>?

    @GET("api/PerformanceAuditAPI/GetPerformanceDayTimeline")
    fun getDayTimeline(
        @Header("Authorization") accessToken: String?,
        @Query("personnelId") personnelId: Int,
        @Query("date") date: String?,
        @Query("from") from: Int,
        @Query("size") size: Int
    ): Response<DayTimelineResponseModel?>?

    @POST("API/RequestApi/ApproveRequest")
    fun approveRequest(
        @Header("Authorization") accessToken: String?,
        @Body requestApprove: CreditParams?
    ): Response<ResponseApprove?>?

    @POST("API/RequestApi/DenyRequest")
    fun denyRequest(
        @Header("Authorization") accessToken: String?,
        @Body requestApprove: CreditParams?
    ): Response<ResponseDeny?>?

    @POST("API/RequestApi/DeleteRequest")
    fun deleteRequest(
        @Header("Authorization") accessToken: String?,
        @Body requestApprove: CreditParams?
    ): Response<ResponseDeny?>?

    @POST("API/RequestApi/AddRequest")
    fun addRequest(
        @Header("Authorization") accessToken: String?,
        @Body addRequestParamsModel: AddRequestParamsModel?
    ): Response<ResponseDeny?>?

    @POST("API/WorkplaceAPI/UpdateWorkplace")
    fun updateWorkplace(
        @Header("Authorization") accessToken: String?,
        @Body workplaceModel: WorkplaceModel?
    ): Response<WorkplaceModel?>?

    @POST("API/WorkplaceAPI/AddWorkplace")
    fun addWorkplace(
        @Header("Authorization") accessToken: String?,
        @Body workplaceModel: WorkplaceModel?
    ): Response<WorkplaceModel?>?

    @POST("API/WorkplaceAPI/DeleteWorkplace")
    fun deleteWorkplace(
        @Header("Authorization") accessToken: String?,
        @Body workplaceModel: IDModel?
    ): Response<WorkplaceModel?>?

    @GET("api/AttendanceLogAPI/GetPairedAttendanceLogs")
    fun getPairedAttendanceLogs(
        @Header("Authorization") accessToken: String?,
        @Query("personnelId") personnelId: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("attendanceTypeValue") attendanceTypeValue: String?
    ): Response<List<PairedAttendanceListResponseModel?>?>?

    @GET("API/RequestApi/GetMyRequests")
    fun getMyRequests(
        @Header("Authorization") accessToken: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("personnelId") personnelId: String?
    ): Response<List<MyRequestsModel?>?>?

    @GET("API/RequestApi/GetPersonnelPendingRequests")
    fun getportfolioItems(
        @Header("Authorization") accessToken: String?,
        @Query("personnelId") personnelId: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("description") description: String?
    ): Response<List<PortfolioResponseModel?>?>?

    @GET("api/AttendanceLogAPI/GetAttendanceLogs")
    fun getAttendanceLogs(
        @Header("Authorization") accessToken: String?,
        @Query("personnelId") personnelId: String?,
        @Query("fromDate") fromDate: String?,
        @Query("toDate") toDate: String?,
        @Query("attendanceTypeValue") attendanceTypeValue: String?
    ): Response<List<AttendanceLogResponseModel?>?>?

    @POST("api/UserAPI/UpdateUserCellPhoneInfo")
    fun updateCellInfo(
        @Header("Authorization") accessToken: String?,
        @Body cellInfoModel: CellInfoModel?
    ): Response<JsonObject?>?

    @POST("api/UserAPI/UpdateUserCellPhoneInfo")
    fun logoutCall(
        @Header("Authorization") accessToken: String?,
        @Body cellInfoModel: CellInfoModel?
    ): POST<JsonObject?>?

    @FormUrlEncoded
    @POST("api/CustomerMessageAPI/UpdateCustomerMessageStatus")
    fun updateStatusCall(
        @Header("Authorization") accessToken: String?,
        @Field("messageId") messageId: String?,
        @Field("messageStatusValue") messageStatusValue: String?,
        @Field("modificationDate") modificationDate: String?
    ): Response<JsonObject?>?

    @GET("api/VersionAPI/CheckForUpdate")
    fun checkForUpdate(
        @Header("Authorization") accessToken: String?,
        @Query("platformValue") platformValue: String?,
        @Query("version") version: String?
    ): Response<CheckUpdateResponseModel?>?

    @GET("api/ProfileAPI/GetPersonnelProfilePictureNameLess")
    fun checkImageFile(@Header("Authorization") accessToken: String?): Response<ResponseBody?>?

    @POST("api/PersonnelAPI/UploadImage")
    fun uploadImage(
        @Header("Authorization") accessToken: String?,
        @Query("pathEnumValue") one: Int?,
        @Body file: RequestBody?
    ): Response<JsonObject?>?

    @GET
    fun getOSMSearch(@Url url: String?): Response<List<OsmSearch?>?>?

    @GET("api/TicketApi/GetTicketCategoryTypes")
    fun getTicketCategoryTypes(@Header("Authorization") accessToken: String?): Response<List<Type?>?>?

    @GET("api/TicketApi/GetTicketPriorityTypes")
    fun getTicketPriorityTypes(@Header("Authorization") accessToken: String?): Response<List<Type?>?>?

    @POST("api/TicketAPI/AddTicket")
    fun addTicket(
        @Header("Authorization") accessToken: String?,
        @Body item: TicketItem?
    ): Response<JsonObject?>?

    @GET("api/TicketAPI/GetTickets")
    fun getTicket(
        @Header("Authorization") accessToken: String?,
        @Query("searchValue") searchValue: String?,
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int
    ): Response<List<TicketItem?>?>?

    @GET("api/TicketAPI/GetTicketActions")
    fun getTicketAction(
        @Header("Authorization") accessToken: String?,
        @Query("ticketId") ticketId: String?,
        @Query("actionTypeValue") actionTypeValue: String?
    ): Response<List<TicketAction?>?>?

    @POST("api/TicketAPI/AddTicketMessage")
    fun addTicketAction(
        @Header("Authorization") accessToken: String?,
        @Body action: TicketAction?
    ): Response<TicketItem?>?

}