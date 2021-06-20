package com.kasra.atency.data.repository

import com.google.gson.JsonObject
import com.kasra.atency.data.model.Info.CellInfoModel
import com.kasra.atency.data.model.LoginResponse
import com.kasra.atency.data.model.checkinout.AttLogModel
import com.kasra.atency.data.model.credit.CreditParams
import com.kasra.atency.data.model.performance.day.DayTimelineParamsModel
import com.kasra.atency.data.model.performance.summary.PerformanceSummaryReportParamsModel
import com.kasra.atency.data.model.portfolio.PortfolioParamsModel
import com.kasra.atency.data.model.request.AddRequestParamsModel
import com.kasra.atency.data.model.ticket.TicketAction
import com.kasra.atency.data.model.ticket.TicketItem
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.kasra.atency.data.network.ApiHelper
import com.kasra.atency.data.network.OAuthInterceptor
import com.kasra.atency.data.prefrences.AppPrefrencesHelper
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.enums.MyEnums
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val preferences: AppPrefrencesHelper,
    auth: OAuthInterceptor
) : UserRepository {
    override suspend fun healthCheck(
        isMain: Boolean,
    ) = apiHelper.healthCheck(isMain)

    override suspend fun loginPostRequest(
        grantType: String?,
        userName: String?,
        password: String?,
        clientId: String?,
    ): Flow<CustomResponse<LoginResponse?>> {
        val response = apiHelper.loginPostRequest(grantType, userName, password, clientId)
        response.collect {
            saveToken(it.data?.access_token!!)
            saveRefreshToken(it.data.refresh_token)
        }

        return response
    }


    override suspend fun logoutCall(
        cellInfoModel: CellInfoModel?,
    ): Flow<CustomResponse<JsonObject?>> = apiHelper.logoutCall(cellInfoModel)


    override suspend fun getUserInfo() = apiHelper.getUserInfo()


    //    region prefrences
    override fun setIsLogin(isLogin: Boolean): Unit = preferences.setIsLogin(isLogin)!!
    override fun getIsLogin(): Boolean = preferences.getIsLogin()!!
    override fun saveToken(token:String): Unit = preferences.setAceesToken(token)!!
    override fun saveRefreshToken(refreshToken:String): Unit = preferences.setRefreshToken(refreshToken)!!

//    endregion
























































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
        apiHelper.getWorkplaces(workplaceType)


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
        toDate
//        MyEnums.PairedAttendanceType.Duty.toString()
    )


    override suspend fun getAttendanceLog(fromDate: String?, toDate: String?) =
        apiHelper.getAttendanceLog(
            "preferences.getUserInfo().getPersonnelId()",
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