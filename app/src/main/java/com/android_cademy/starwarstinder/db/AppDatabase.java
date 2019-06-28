package com.android_cademy.starwarstinder.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.android_cademy.starwarstinder.model.Profile;

@Database(entities = {Profile.class}, version = 1)
public abstract class AppDatabase
        extends RoomDatabase {
    public abstract ProfileDao profileDao();
}

