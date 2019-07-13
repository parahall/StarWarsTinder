package com.android_academy.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProfileDao {

    @Query("SELECT * FROM Profile")
    fun getAll(): LiveData<List<Profile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg profile: Profile)

    @Query("DELETE FROM Profile")
    fun deleteProfiles()

    @Query("SELECT COUNT(NAME) FROM Profile")
    fun countProfiles(): Int
}
