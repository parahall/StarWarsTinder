package com.android_cademy.starwarstinder.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android_cademy.starwarstinder.model.Profile;

import java.util.List;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM Profile")
    LiveData<List<Profile>> getProfiles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(Profile... profile);

    @Query("DELETE FROM Profile")
    void deleteProfiles();

    @Query("SELECT COUNT(NAME) FROM Profile")
    int countProfiles();
}
