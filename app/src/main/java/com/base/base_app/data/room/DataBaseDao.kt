package com.base.bime.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataBaseDao {
//    @Query("select * from user_info")
//    fun getUserList():LiveData<List<UserInfo>>
//
//    @Insert (onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUsers(userInfos:List<UserInfo>)
}