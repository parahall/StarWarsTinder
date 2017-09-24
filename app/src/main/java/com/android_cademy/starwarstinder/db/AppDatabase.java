package com.android_cademy.starwarstinder.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.android_cademy.starwarstinder.model.Profile;

@Database(entities = { Profile.class }, version = 1) public abstract class AppDatabase
    extends RoomDatabase {
  public abstract ProfileDao profileModel();
}

