package com.kasra.bime.data.room

import com.kasra.atency.data.room.ApplicationDB
import javax.inject.Inject

class DataBaseImpl @Inject constructor(val applicationDB: ApplicationDB):DataBaseHelper {

//    override fun getUsers():LiveData<List<UserInfo>> = applicationDB.dataBaseDao().getUserList()
//    override suspend fun setUsers(userInfos:List<UserInfo>) = applicationDB.dataBaseDao().insertUsers(userInfos)

}