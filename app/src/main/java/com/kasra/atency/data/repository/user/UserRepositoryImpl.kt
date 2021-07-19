package com.kasra.atency.data.repository.user

import com.google.gson.JsonObject
import com.kasra.atency.data.model.Info.CellInfoModel
import com.kasra.atency.data.model.LoginResponse
import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.checkinout.AttLogModel
import com.kasra.atency.data.model.credit.CreditParams
import com.kasra.atency.data.model.performance.day.DayTimelineParamsModel
import com.kasra.atency.data.model.performance.summary.PerformanceSummaryReportParamsModel
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.model.portfolio.PortfolioParamsModel
import com.kasra.atency.data.model.request.AddRequestParamsModel
import com.kasra.atency.data.model.ticket.TicketAction
import com.kasra.atency.data.model.ticket.TicketItem
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.kasra.atency.data.network.ApiHelper
import com.kasra.atency.data.network.OAuthInterceptor
import com.kasra.atency.data.prefrences.AppPrefrencesHelper
import com.kasra.atency.data.repository.BaseRepository
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.enums.MyEnums
import com.kasra.bime.data.room.DataBaseHelper
import io.sentry.Sentry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val preferences: AppPrefrencesHelper,
    private val dataBaseHelper: DataBaseHelper,
    private val baseRepository: BaseRepository,
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
    ): Flow<CustomResponse<LoginResponse>> {
        val response = apiHelper.loginPostRequest(grantType, userName, password, clientId)
        response.collect {
            if (it.status == CustomResponse.Status.SUCCESS) {
                saveToken(it.data?.access_token!!)
                saveRefreshToken(it.data.refresh_token)
                getUserInfo()
            }
        }
        return response
    }

    override suspend fun getBadgeMessage() = apiHelper.getBadgeMessage()

    override suspend fun logoutCall(
        cellInfoModel: CellInfoModel?,
    ): Flow<CustomResponse<JsonObject>> = apiHelper.logoutCall(cellInfoModel)

    override suspend fun getUserInfo(): Flow<CustomResponse<UserInfo>> {
        val response = apiHelper.getUserInfo()
        response.collect {
            Sentry.configureScope { scope ->
                scope.setContexts("GivenName", it.data?.givenName.toString())
                scope.setContexts("Website", it.data?.website!!)
            }
            preferences.saveWebSite(it.data?.website!!)
            dataBaseHelper.deleteUsers();
            dataBaseHelper.insertUsers(it.data)
            setIsLogin(true)
        }
        return response
    }

    override suspend fun getPermissions(
        from: Int,
        size: Int
    ): Flow<CustomResponse<List<PermissionResponseModel>>> {
        val result = apiHelper.getPermissions(from, size)
        (result.collect { insertPermission(it.data!!) })
        return result
    }

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

    //    region prefrences
    override fun setIsLogin(isLogin: Boolean): Unit = preferences.setIsLogin(isLogin)!!
    override fun getIsLogin(): Boolean = preferences.getIsLogin()!!
    override fun saveToken(token: String): Unit = preferences.setAceesToken(token)!!
    override fun saveRefreshToken(refreshToken: String): Unit =
        preferences.setRefreshToken(refreshToken)!!
    override fun saveDeviceID(deviceId: String): Unit =
        preferences.saveDeviceID(deviceId)
    override fun getDeviceID(deviceId: String): String =
        preferences.getDeviceID()

    //    endregion
//    region database
    private suspend fun insertPermission(permissions: List<PermissionResponseModel>) {
        dataBaseHelper.insertPermisions(permissions)
    }

    override fun getUserInfoLocal() = dataBaseHelper.getUsers()


//    endregion


    override suspend fun removeAll() {
        baseRepository.removeAllThing()
    }


    override suspend fun getAllRequestTypes() = apiHelper.getAllRequestTypes()


    override suspend fun getMyRequests(fromDate: String?, toDate: String?, personnelId: String?) =
        apiHelper.getMyRequests(fromDate, toDate, personnelId)


    override suspend fun getProfilePicture() = apiHelper.getProfilePicture()


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


    override suspend fun checkForUpdate(version: String?) =
        apiHelper.checkForUpdate(
            MyEnums.PlatformValue.ANDROID.toString()
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