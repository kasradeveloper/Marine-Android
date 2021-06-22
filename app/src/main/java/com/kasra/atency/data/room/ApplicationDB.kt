package com.kasra.atency.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bilerplatemvvm.BuildConfig
import com.kasra.atency.data.model.UserInfo
import com.kasra.atency.data.model.permission.PermissionResponseModel
import com.kasra.atency.data.model.user.Person
import com.kasra.atency.data.network.ProductTypeConverter
import com.kasra.atency.data.room.dao.UserDao

@Database(entities = [Person::class, UserInfo::class , PermissionResponseModel::class], version = 1)
@TypeConverters(ProductTypeConverter::class)

abstract class ApplicationDB: RoomDatabase() {
      abstract fun userDao(): UserDao
    companion object {
        @Volatile
        private var instance: ApplicationDB? = null
        fun getDataBase(context: Context): ApplicationDB = instance ?: synchronized(this){ instance
            ?: buildDb(context).also { instance =it }}
        private fun buildDb(context: Context)= Room.databaseBuilder(
            context,
            ApplicationDB::class.java, (BuildConfig.db_name).toString()
        ).fallbackToDestructiveMigration().build()
    }
}