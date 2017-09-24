package com.android_cademy.starwarstinder.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.android_cademy.starwarstinder.model.Profile;
import java.util.Date;

@Dao
public interface ProfileDao {
  /**
   * Gets the weather for a single day
   *
   * @param date The date you want weather for
   * @return {@link LiveData} with weather for a single day
   */
  @Query("SELECT * FROM profile");
  LiveData<Profile> getProfiles();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void bulkInsert(Profile... weather);

  /**
   * Deletes any weather data older than the given day
   *
   * @param date The date to delete all prior weather from (exclusive)
   */
  @Query("DELETE FROM weather WHERE date < :date")
  void deleteOldWeather(Date date);
}
