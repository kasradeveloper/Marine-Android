package com.base.bime.data.room

import androidx.lifecycle.LiveData
import javax.inject.Inject

class DataBaseImpl @Inject constructor(val applicationDB: ApplicationDB):DataBaseHelper {

//    override fun getUsers():LiveData<List<UserInfo>> = applicationDB.dataBaseDao().getUserList()
//    override suspend fun setUsers(userInfos:List<UserInfo>) = applicationDB.dataBaseDao().insertUsers(userInfos)

}