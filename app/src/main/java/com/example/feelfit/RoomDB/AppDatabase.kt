package com.example.feelfit.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InfoEntityC::class], version = 1, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase?=null
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java,"feelfit"
                ).build()
                INSTANCE =instance
                return instance

            }

        }

    }

}
