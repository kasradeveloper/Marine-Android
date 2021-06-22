package com.kasra.atency.data.repository.workplace

import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.kasra.atency.utility.CustomResponse
import kotlinx.coroutines.flow.Flow

interface WorkPlaceRepository {
    suspend fun getWorkplaces(workplaceType:Int): Flow<CustomResponse<List<WorkplaceModel?>?>>

}