package com.kasra.atency.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bilerplatemvvm.BuildConfig
import com.example.bilerplatemvvm.BuildConfig.db_name
import com.example.bilerplatemvvm.R
import com.kasra.atency.data.model.user.Person
import com.kasra.bime.data.room.DataBaseDao

@Database(entities= [Person::class],version = 1,exportSchema = false)
abstract class ApplicationDB: RoomDatabase() {
      abstract fun dataBaseDao(): DataBaseDao
    companion object {
        @Volatile
        private var instance: ApplicationDB? = null
        fun getDataBase(context: Context): ApplicationDB = instance ?: synchronized(this){ instance
            ?: buildDb(context).also { instance =it }}
        private fun buildDb(context: Context)= Room.databaseBuilder(context,
            ApplicationDB::class.java,(BuildConfig.db_name).toString()).fallbackToDestructiveMigration().build()
    }
}