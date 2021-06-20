package com.kasra.atency.data.repository

import com.google.gson.JsonObject
import com.kasra.atency.data.model.Info.CellInfoModel
import com.kasra.atency.data.model.LoginResponse
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
import com.kasra.atency.data.model.performance.day.DayTimelineParamsModel
import com.kasra.atency.data.model.performance.day.DayTimelineResponseModel
import com.kasra.atency.data.model.performance.summary.PerformanceSummaryReportParamsModel
import com.kasra.atency.data.model.performance.summary.PerformanceSummaryReportResponseModel
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.model.portfolio.PortfolioParamsModel
import com.kasra.atency.data.model.portfolio.PortfolioResponseModel
import com.kasra.atency.data.model.request.AddRequestParamsModel
import com.kasra.atency.data.model.request.MyRequestsModel
import com.kasra.atency.data.model.ticket.TicketAction
import com.kasra.atency.data.model.ticket.TicketItem
import com.kasra.atency.data.model.update.CheckUpdateResponseModel
import com.kasra.atency.data.model.workperiod.GetAllWorkperiods
import com.kasra.atency.data.model.workplace.Type
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.kasra.atency.utility.CustomResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody

interface UserRepository {
    suspend fun healthCheck(isMain: Boolean): Flow<CustomResponse<HealthCheckModel?>>
    suspend fun loginPostRequest(
        grantType: String?,
        userName: String?,
        password: String?,
        clientId: String?
    ): Flow<CustomResponse<LoginResponse?>>
    suspend fun getWorkplaces(workplaceType:Int):Flow<CustomResponse<List<WorkplaceModel?>?>>
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

    suspend fun getProfilePicture(): Flow<CustomResponse<ResponseBody?>>
    suspend fun getPermissions(
        from: Int,
        size: Int
    ): Flow<CustomResponse<List<PermissionResponseModel?>?>>

    suspend fun getportfolioItems(portfolioParamsModel: PortfolioParamsModel): Flow<CustomResponse<List<PortfolioResponseModel?>?>>
    suspend fun getWorkPeriod(fromDate: String?): Flow<CustomResponse<GetAllWorkperiods?>>
    suspend fun getPairedAttendanceLogs(
        personnelId: String?,
        fromDate: String?,
        toDate: String?
    ): Flow<CustomResponse<List<PairedAttendanceListResponseModel?>?>>

    suspend fun getAttendanceLog(
        fromDate: String?,
        toDate: String?
    ): Flow<CustomResponse<List<AttendanceLogResponseModel?>?>>

    suspend fun approveRequest(creditParams: CreditParams?): Flow<CustomResponse<ResponseApprove?>>
    suspend fun denyRequest(creditParams: CreditParams?): Flow<CustomResponse<ResponseDeny?>>
    suspend fun deleteRequest(creditParams: CreditParams?): Flow<CustomResponse<ResponseDeny?>>
    suspend fun addRequest(addRequestParamsModel: AddRequestParamsModel?): Flow<CustomResponse<ResponseDeny?>>
    suspend fun addWorkplace(workplaceModel: WorkplaceModel?): Flow<CustomResponse<WorkplaceModel?>>
    suspend fun deleteWorkplace(workplace: WorkplaceModel?): Flow<CustomResponse<WorkplaceModel?>>
    suspend fun updateWorkplace(workplace: WorkplaceModel?): Flow<CustomResponse<WorkplaceModel?>>
    suspend fun getDayTimeline(
        dayTimelineParamsModel: DayTimelineParamsModel,
        pageNumber: Int,
        pageSize: Int
    ): Flow<CustomResponse<DayTimelineResponseModel?>>

    suspend fun getMonthlyPerformance(
        performanceSummary: PerformanceSummaryReportParamsModel,
        pageNumber: Int,
        pageSize: Int
    ): Flow<CustomResponse<PerformanceSummaryReportResponseModel?>>

    suspend fun attLogPostRequest(attLogModel: AttLogModel?): Flow<CustomResponse<AttLogResponseModel?>>
    suspend fun updateCellInfo(cellInfoModel: CellInfoModel?): Flow<CustomResponse<JsonObject?>>
    suspend fun updateStatusCall(
        messageId: String?,
        messageStatus: String?,
        modificationValue: String?
    ): Flow<CustomResponse<JsonObject?>>

    suspend fun checkForUpdate(
        version: String?,
        cellInfoModel: CellInfoModel?
    ): Flow<CustomResponse<CheckUpdateResponseModel?>>

    suspend fun getTicketCategoryTypes(): Flow<CustomResponse<List<Type?>?>>
    suspend fun getTicketPriorityTypes(): Flow<CustomResponse<List<Type?>?>>
    suspend fun addTicket(ticketItem: TicketItem?): Flow<CustomResponse<JsonObject?>>
    suspend fun getTicket(
        searchValue: String?,
        pageNumber: Int,
        pageSize: Int
    ): Flow<CustomResponse<List<TicketItem?>?>>

    suspend fun getTicketAction(
        ticketId: String?,
        actionTypeValue: String?
    ): Flow<CustomResponse<List<TicketAction?>?>>

    suspend fun addTicketAction(action: TicketAction?): Flow<CustomResponse<TicketItem?>>
    fun setIsLogin(isLogin: Boolean)
    fun getIsLogin(): Boolean
    fun saveRefreshToken(refreshToken: String)
    fun saveToken(token: String)
}