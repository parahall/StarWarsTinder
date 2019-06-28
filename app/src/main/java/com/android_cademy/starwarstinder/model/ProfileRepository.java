package com.android_cademy.starwarstinder.model;

import androidx.lifecycle.LiveData;

import com.android_cademy.starwarstinder.db.AppDatabase;
import com.android_cademy.starwarstinder.network.ProfileNetworkDataSource;

import java.util.List;

import javax.inject.Inject;

public class ProfileRepository {

    private static int MIN_PROFILES_TO_CACHE = 10;
    private final AppDatabase db;
    private final ProfileNetworkDataSource profileNetworkDataSource;

    @Inject
    public ProfileRepository(final AppDatabase db, ProfileNetworkDataSource dataSource) {
        this.db = db;
        this.profileNetworkDataSource = dataSource;

        LiveData<List<Profile>> networkData = dataSource.getCurrentProfiles();
        networkData.observeForever(profilesFromNetwork -> new Thread(() -> {
            deleteOldData();
            Profile[] profile = profilesFromNetwork.toArray(new Profile[profilesFromNetwork.size
                    ()]);
            db.profileDao().bulkInsert(profile);
        }).start());
    }

    private void deleteOldData() {
        db.profileDao().deleteProfiles();
    }

    public LiveData<List<Profile>> getProfiles() {
        initializeData();
        return db.profileDao().getProfiles();
    }

    private void initializeData() {
        //regular thread is used to simplify the example. don't do that in the production :)
        new Thread(() -> {
            if (isFetchNeeded()) {
                startFetchProfilesService();
            }
        }).start();
    }

    private void startFetchProfilesService() {
        profileNetworkDataSource.startFetchProfiles();
    }

    private boolean isFetchNeeded() {
        int count = db.profileDao().countProfiles();
        return count <= ProfileRepository.MIN_PROFILES_TO_CACHE;
    }
}
