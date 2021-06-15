package com.base.base_app.data.repository

import com.base.base_app.data.model.Info.CellInfoModel
import com.base.base_app.data.model.checkinout.AttLogModel
import com.base.base_app.data.model.credit.CreditParams
import com.base.base_app.data.model.performance.day.DayTimelineParamsModel
import com.base.base_app.data.model.performance.summary.PerformanceSummaryReportParamsModel
import com.base.base_app.data.model.portfolio.PortfolioParamsModel
import com.base.base_app.data.model.request.AddRequestParamsModel
import com.base.base_app.data.model.ticket.TicketAction
import com.base.base_app.data.model.ticket.TicketItem
import com.base.base_app.data.model.workplace.WorkplaceModel
import com.base.base_app.data.network.ApiHelper
import com.base.base_app.data.network.getResult
import com.base.base_app.utility.CustomResponse
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import java.util.prefs.AbstractPreferences
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val preferences: AbstractPreferences
) : UserRepository {
    override suspend fun healthCheck(
        isMain: Boolean,
    ) = apiHelper.healthCheck(isMain)

    override suspend fun loginPostRequest(
        grantType: String?,
        userName: String?,
        password: String?,
        clientId: String?,
    ) = apiHelper.loginPostRequest(grantType, userName, password, clientId)


    override suspend fun logoutCall(
        cellInfoModel: CellInfoModel?,
    ): Flow<CustomResponse<JsonObject?>> = apiHelper.logoutCall(cellInfoModel)


    override suspend fun getUserInfo() = apiHelper.getUserInfo()

    override suspend fun getAllMessages(
        personelId: Int,
        from: Int,
        size: Int,
        searchedText: String?
    ) =
        apiHelper.getAllMessages(
            personelId,
            from,
            size,
            searchedText
        )


    override suspend fun getBadgeMessage() = apiHelper.getBadgeMessage()

    override suspend fun getWorkplaces(workplaceType: Int) =
        apiHelper.getWorkplaces(workplaceType, size)


    override suspend fun getAllRequestTypes() = apiHelper.getAllRequestTypes()


    override suspend fun getMyRequests(fromDate: String?, toDate: String?, personnelId: String?) =
        apiHelper.getMyRequests(fromDate, toDate, personnelId)


    override suspend fun getProfilePicture() = apiHelper.getProfilePicture()


    override suspend fun getPermissions(from: Int, size: Int) =
        apiHelper.getPermissions(from, size)


    override suspend fun getportfolioItems(portfolioParamsModel: PortfolioParamsModel) =
        apiHelper.getportfolioItems(portfolioParamsModel)


    override suspend fun getWorkPeriod(fromDate: String?) =
        apiHelper.getWorkPeriod(fromDate)


    override suspend fun getPairedAttendanceLogs(
        personnelId: String?,
        fromDate: String?,
        toDate: String?
    ) = apiHelper.getPairedAttendanceLogs(
        personnelId,
        fromDate,
        toDate,
        MyEnums.PairedAttendanceType.Duty.toString()
    )


    override suspend fun getAttendanceLog(fromDate: String?, toDate: String?) =
        apiHelper.getAttendanceLog(
            preferences.getUserInfo().getPersonnelId(),
            fromDate,
            toDate,
            MyEnums.PairedAttendanceType.Duty.toString()
        )


    override suspend fun approveRequest(creditParams: CreditParams?) =
        apiHelper.approveRequest(creditParams)

    override suspend fun denyRequest(creditParams: CreditParams?) =
        apiHelper.denyRequest(creditParams)

    override suspend fun deleteRequest(creditParams: CreditParams?) =
        apiHelper.deleteRequest(creditParams)

    override suspend fun addRequest(addRequestParamsModel: AddRequestParamsModel?) =
        apiHelper.addRequest(addRequestParamsModel)

    override suspend fun addWorkplace(workplaceModel: WorkplaceModel?) =
        apiHelper.addWorkplace(workplaceModel)

    override suspend fun deleteWorkplace(workplace: WorkplaceModel?) =
        apiHelper.deleteWorkplace(workplace)

    override suspend fun updateWorkplace(workplace: WorkplaceModel?) =
        apiHelper.updateWorkplace(workplace)

    override suspend fun getDayTimeline(
        dayTimelineParamsModel: DayTimelineParamsModel,
        pageNumber: Int,
        pageSize: Int
    ) =
        apiHelper.getDayTimeline(
            dayTimelineParamsModel,
            pageNumber,
            pageSize
        )


    override suspend fun getMonthlyPerformance(
        performanceSummary: PerformanceSummaryReportParamsModel,
        pageNumber: Int,
        pageSize: Int
    ) =
        apiHelper.getMonthlyPerformance(
            performanceSummary,
            pageNumber,
            pageSize
        )


    override suspend fun attLogPostRequest(attLogModel: AttLogModel?) =
        apiHelper.attLogPostRequest(attLogModel)

    override suspend fun updateCellInfo(cellInfoModel: CellInfoModel?) =
        apiHelper.updateCellInfo(cellInfoModel)

    override suspend fun updateStatusCall(
        messageId: String?,
        messageStatus: String?,
        modificationValue: String?
    ) =
        apiHelper.updateStatusCall(
            messageId,
            messageStatus,
            modificationValue
        )


    override suspend fun checkForUpdate(version: String?, cellInfoModel: CellInfoModel?) =
        apiHelper.checkForUpdate(
            MyEnums.PlatformValue.ANDROID.toString(),
            cellInfoModel
        )


    override suspend fun getTicketCategoryTypes() =

    apiHelper.getTicketCategoryTypes()


    override suspend fun getTicketPriorityTypes() =

    apiHelper.getTicketPriorityTypes()


    override suspend fun addTicket(ticketItem: TicketItem?) =

    apiHelper.addTicket(ticketItem)


    override suspend fun getTicket(
        searchValue: String?,
        pageNumber: Int,
        pageSize: Int
    ) =

    apiHelper.getTicket(
    searchValue,
    pageNumber,
    pageSize
    )


    override suspend fun getTicketAction(
        ticketId: String?,
        actionTypeValue: String?
    ) =

    apiHelper.getTicketAction(
    ticketId,
    actionTypeValue
    )


    override suspend fun addTicketAction(
        action: TicketAction?
    ) =

    apiHelper.addTicketAction(
    action
    )

}