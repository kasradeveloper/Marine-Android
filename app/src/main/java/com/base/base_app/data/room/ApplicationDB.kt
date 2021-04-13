package com.base.bime.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.base.base_app.data.model.Person
import com.example.bilerplatemvvm.R

@Database(entities= [Person::class],version = 1,exportSchema = false)
abstract class ApplicationDB: RoomDatabase() {
      abstract fun dataBaseDao():DataBaseDao
    companion object {
        @Volatile
        private var instance: ApplicationDB? = null
        fun getDataBase(context: Context):ApplicationDB= instance?: synchronized(this){ instance?: buildDb(context).also { instance=it }}
        private fun buildDb(context: Context)= Room.databaseBuilder(context,ApplicationDB::class.java,(R.string.db_name).toString()).fallbackToDestructiveMigration().build()
    }
}