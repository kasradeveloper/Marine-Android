package com.kasra.bime.data.room

import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.permission.PermissionResponseModel
import kotlinx.coroutines.flow.Flow

interface DataBaseHelper {
//    fun getUsers(): LiveData<List<UserInfo>>
//    suspend fun setUsers(userInfos:List<UserInfo>)

    fun getUsers(): Flow<UserInfo?>
    suspend fun insertUsers(userInfo: UserInfo)
    suspend fun deleteUsers()
    fun getPermisssions(): Flow<List<PermissionResponseModel>?>
    suspend fun insertPermisions(permissions: List<PermissionResponseModel>)
    suspend fun deletePermissions()
    suspend fun deleteAllThing()
}