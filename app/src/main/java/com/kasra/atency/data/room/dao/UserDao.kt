package com.kasra.atency.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.permission.PermissionResponseModel
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {
    //------------------------------------SELECT
    @Query("SELECT * FROM  user_info ")
    fun getUserInfo(): Flow<UserInfo>

    @Query("SELECT * FROM  permission ")
    fun getPermissionModel(): Flow<List<PermissionResponseModel>>

    //------------------------------------INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInfo(userInfo: UserInfo?)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPermission(permission:List<PermissionResponseModel>)

    //-------------------------------------delete
    @Query("DELETE FROM user_info")
    suspend fun deleteUserInfo()
    @Query("DELETE FROM permission")
    suspend fun deletePermission()
}