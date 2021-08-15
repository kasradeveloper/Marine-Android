package com.kasra.bime.data.room

import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.room.ApplicationDB
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataBaseImpl @Inject constructor(private val applicationDB: ApplicationDB) : DataBaseHelper {
    //    region user
    override fun getUsers(): Flow<UserInfo?> = applicationDB.userDao().getUserInfo()
    override suspend fun insertUsers(userInfo: UserInfo) =
        applicationDB.userDao().insertUserInfo(userInfo)
    override suspend fun deleteUsers() = applicationDB.userDao().deleteUserInfo()
    override fun getPermisssions(): Flow<List<PermissionResponseModel>> = applicationDB.userDao().getPermissionModel()
    override suspend fun insertPermisions(permissions:List<PermissionResponseModel>) =
        applicationDB.userDao().insertPermission(permissions)
    override suspend fun deletePermissions() = applicationDB.userDao().deletePermission()
    //    endregion
    override suspend fun deleteAllThing(){
        applicationDB.clearAllTables()
    }
}