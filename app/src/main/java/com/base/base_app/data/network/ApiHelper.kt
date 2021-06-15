package com.base.base_app.data.network

import com.base.base_app.data.model.Info.CellInfoModel
import com.base.base_app.data.model.LoginResponse
import com.base.base_app.data.model.UserInfo
import com.base.base_app.data.model.attendance.AttendanceLogResponseModel
import com.base.base_app.data.model.checkinout.AttLogModel
import com.base.base_app.data.model.checkinout.AttLogResponseModel
import com.base.base_app.data.model.credit.CreditParams
import com.base.base_app.data.model.credit.ResponseApprove
import com.base.base_app.data.model.credit.ResponseDeny
import com.base.base_app.data.model.health.HealthCheckModel
import com.base.base_app.data.model.message.MessageModel
import com.base.base_app.data.model.paired.PairedAttendanceListResponseModel
import com.base.base_app.data.model.performance.day.DayTimelineParamsModel
import com.base.base_app.data.model.performance.day.DayTimelineResponseModel
import com.base.base_app.data.model.performance.summary.PerformanceSummaryReportParamsModel
import com.base.base_app.data.model.performance.summary.PerformanceSummaryReportResponseModel
import com.base.base_app.data.model.permission.PermissionResponseModel
import com.base.base_app.data.model.portfolio.PortfolioParamsModel
import com.base.base_app.data.model.portfolio.PortfolioResponseModel
import com.base.base_app.data.model.request.AddRequestParamsModel
import com.base.base_app.data.model.request.MyRequestsModel
import com.base.base_app.data.model.ticket.TicketAction
import com.base.base_app.data.model.ticket.TicketItem
import com.base.base_app.data.model.update.CheckUpdateResponseModel
import com.base.base_app.data.model.workperiod.GetAllWorkperiods
import com.base.base_app.data.model.workplace.Type
import com.base.base_app.data.model.workplace.WorkplaceModel
import com.base.base_app.utility.CustomResponse
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody


interface ApiHelper {

    suspend fun healthCheck(isMain: Boolean): Flow<CustomResponse<HealthCheckModel?>>
    suspend fun loginPostRequest(
        grantType: String?,
        userName: String?,
        password: String?,
        clientId: String?
    ): Flow<CustomResponse<LoginResponse?>>

    suspend fun logoutCall(cellInfoModel: CellInfoModel?): Flow<CustomResponse<JsonObject?>>
    suspend fun getUserInfo(): Flow<CustomResponse<UserInfo?>>
    suspend fun getAllMessages(
        personelId: Int,
        from: Int,
        size: Int,
        searchedText: String?
    ): Flow<CustomResponse<List<MessageModel?>?>>

    suspend fun getBadgeMessage(): Flow<CustomResponse<JsonObject?>>

    suspend fun getWorkplaces(workplaceType: Int): Flow<CustomResponse<List<WorkplaceModel?>?>>

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
        personnelId: String?,
        fromDate: String?,
        toDate: String?,
        PairedAttendanceType: String
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
}