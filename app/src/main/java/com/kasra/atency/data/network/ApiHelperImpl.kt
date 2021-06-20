package com.kasra.atency.data.network


import com.google.gson.JsonObject
import com.kasra.atency.data.model.Info.CellInfoModel
import com.kasra.atency.data.model.checkinout.AttLogModel
import com.kasra.atency.data.model.credit.CreditParams
import com.kasra.atency.data.model.performance.day.DayTimelineParamsModel
import com.kasra.atency.data.model.performance.summary.PerformanceSummaryReportParamsModel
import com.kasra.atency.data.model.portfolio.PortfolioParamsModel
import com.kasra.atency.data.model.request.AddRequestParamsModel
import com.kasra.atency.data.model.ticket.TicketAction
import com.kasra.atency.data.model.ticket.TicketItem
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.enums.MyEnums
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ApiHelperImpl @Inject constructor(private val services: ApiServices) : ApiHelper {

    override suspend fun healthCheck(
        isMain: Boolean,
    ) = getResult { services.healthCheck() }

    override suspend fun loginPostRequest(
        grantType: String?,
        userName: String?,
        password: String?,
        clientId: String?,
    ) = getResult { services.loginPostRequest(grantType, userName, password, clientId) }


    override suspend fun logoutCall(
        cellInfoModel: CellInfoModel?,
    ): Flow<CustomResponse<JsonObject?>> = getResult { services.logoutCall(cellInfoModel) }


    override suspend fun getUserInfo() = getResult { services.getUserInfo() }

    override suspend fun getAllMessages(
        personelId: Int,
        from: Int,
        size: Int,
        searchedText: String?
    ) = getResult {
        services.getAllMessages(
            personelId,
            from,
            size,
            searchedText
        )
    }

    override suspend fun getBadgeMessage() = getResult { services.getBadgeMessage() }

    override suspend fun getWorkplaces(workplaceType: Int) =
        getResult { services.getWorkplaces(workplaceType) }


    override suspend fun getAllRequestTypes() = getResult { services.getAllRequestTypes() }


    override suspend fun getMyRequests(fromDate: String?, toDate: String?, personnelId: String?) =
        getResult { services.getMyRequests(fromDate, toDate, personnelId) }


    override suspend fun getProfilePicture() = getResult { services.getProfilePicture() }


    override suspend fun getPermissions(from: Int, size: Int) =
        getResult { services.getPermissions(from, size) }


    override suspend fun getportfolioItems(portfolioParamsModel: PortfolioParamsModel) = getResult {
        services.getportfolioItems(
            portfolioParamsModel.personnel,
            portfolioParamsModel.fromDate,
            portfolioParamsModel.toDate,
            portfolioParamsModel.description
        )
    }


    override suspend fun getWorkPeriod(fromDate: String?) =
        getResult { services.getWorkPeriod(fromDate) }


    override suspend fun getPairedAttendanceLogs(
        personnelId: String?,
        fromDate: String?,
        toDate: String?
    ) = getResult {
        services.getPairedAttendanceLogs(
            personnelId,
            fromDate,
            toDate,
            MyEnums.PairedAttendanceType.Duty.toString()
        )
    }

    override suspend fun getAttendanceLog(personnelId: String?,fromDate: String?, toDate: String?,PairedAttendanceType:String) = getResult {
        services.getAttendanceLogs(
            personnelId,
            fromDate,
            toDate,
            PairedAttendanceType
        )
    }


    override suspend fun approveRequest(creditParams: CreditParams?) =
        getResult { services.approveRequest(creditParams) }

    override suspend fun denyRequest(creditParams: CreditParams?) =
        getResult { services.denyRequest(creditParams) }

    override suspend fun deleteRequest(creditParams: CreditParams?) =
        getResult { services.deleteRequest(creditParams) }

    override suspend fun addRequest(addRequestParamsModel: AddRequestParamsModel?) =
        getResult { services.addRequest(addRequestParamsModel) }

    override suspend fun addWorkplace(workplaceModel: WorkplaceModel?) =
        getResult { services.addWorkplace(workplaceModel) }

    override suspend fun deleteWorkplace(workplace: WorkplaceModel?) =
        getResult { services.deleteWorkplace(workplace) }

    override suspend fun updateWorkplace(workplace: WorkplaceModel?) =
        getResult { services.updateWorkplace(workplace) }

    override suspend fun getDayTimeline(
        dayTimelineParamsModel: DayTimelineParamsModel,
        pageNumber: Int,
        pageSize: Int
    ) = getResult {
        services.getDayTimeline(
            dayTimelineParamsModel.personnelId,
            dayTimelineParamsModel.date,
            pageNumber,
            pageSize
        )
    }

    override suspend fun getMonthlyPerformance(
        performanceSummary: PerformanceSummaryReportParamsModel,
        pageNumber: Int,
        pageSize: Int
    ) =
        getResult {
            services.getMonthlyPerformance(
                performanceSummary.startDate,
                performanceSummary.endDate,
                performanceSummary.personnelId,
                pageNumber,
                pageSize
            )
        }

    override suspend fun attLogPostRequest(attLogModel: AttLogModel?) =
        getResult { services.attLogPostRequest(attLogModel) }

    override suspend fun updateCellInfo(cellInfoModel: CellInfoModel?) =
        getResult { services.updateCellInfo(cellInfoModel) }

    override suspend fun updateStatusCall(
        messageId: String?,
        messageStatus: String?,
        modificationValue: String?
    ) =
        getResult {
            services.updateStatusCall(
                messageId,
                messageStatus,
                modificationValue
            )
        }

    override suspend fun checkForUpdate(version: String?, cellInfoModel: CellInfoModel?) =
        getResult {
            services.checkForUpdate(
                MyEnums.PlatformValue.ANDROID.toString(),
                version
            )
        }

    override suspend fun getTicketCategoryTypes() =
        getResult {
            services.getTicketCategoryTypes()
        }

    override suspend fun getTicketPriorityTypes() =
        getResult {
            services.getTicketPriorityTypes()
        }

    override suspend fun addTicket(ticketItem: TicketItem?) =
        getResult {
            services.addTicket(ticketItem)
        }

    override suspend fun getTicket(
        searchValue: String?,
        pageNumber: Int,
        pageSize: Int
    ) =
        getResult {
            services.getTicket(
                searchValue,
                pageNumber,
                pageSize
            )
        }

    override suspend fun getTicketAction(
        ticketId: String?,
        actionTypeValue: String?
    ) =
        getResult {
            services.getTicketAction(
                ticketId,
                actionTypeValue
            )
        }

    override suspend fun addTicketAction(
        action: TicketAction?
    ) =
        getResult {
            services.addTicketAction(
                action
            )
        }
}