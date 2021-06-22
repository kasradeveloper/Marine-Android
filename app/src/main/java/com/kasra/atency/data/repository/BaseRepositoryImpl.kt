package com.kasra.atency.data.repository

import com.kasra.atency.data.network.ApiHelper
import com.kasra.bime.data.room.DataBaseHelper
import javax.inject.Inject

class BaseRepositoryImpl @Inject constructor(
    private val dataBaseHelper: DataBaseHelper,
    private val apiHelper: ApiHelper,

    ): BaseRepository {
        override suspend fun removeAllThing(){
            dataBaseHelper.deleteAllThing()
        }
}