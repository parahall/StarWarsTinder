package com.android_cademy.starwarstinder.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

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
