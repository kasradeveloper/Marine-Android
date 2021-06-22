package com.kasra.atency.data.repository.workplace

import com.kasra.atency.data.network.ApiHelper
import com.kasra.atency.data.network.OAuthInterceptor
import com.kasra.atency.data.prefrences.AppPrefrencesHelper
import com.kasra.bime.data.room.DataBaseHelper
import javax.inject.Inject

class WorkPlaceRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val preferences: AppPrefrencesHelper,
    private val dataBaseHelper: DataBaseHelper,
    auth: OAuthInterceptor
) : WorkPlaceRepository {
    override suspend fun getWorkplaces(workplaceType: Int) =
        apiHelper.getWorkplaces(workplaceType)
}