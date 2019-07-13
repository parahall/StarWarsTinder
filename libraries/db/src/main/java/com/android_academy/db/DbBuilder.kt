package com.android_academy.db

import android.content.Context
import androidx.room.Room

class DbBuilder {
    data class Builder(val context: Context) {
        fun build(): AppDatabase {
            //        val db = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "profiles_db").build()
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "profiles_db")
//        return Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
                    .build()
        }
    }
}