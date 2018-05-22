package com.android_cademy.starwarstinder.network;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.android_cademy.starwarstinder.ResourcesUtil;
import com.android_cademy.starwarstinder.StarWarsApp;
import com.android_cademy.starwarstinder.model.Profile;

import java.util.List;

import javax.inject.Inject;

public class ProfileFetchService extends IntentService {

    @Inject
    ProfileNetworkDataSource profileNetworkDataSource;

    public ProfileFetchService() {
        super("ProfileFetchService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ((StarWarsApp) getApplicationContext()).getAppComponent().inject(this);

        List<Profile> profiles = ResourcesUtil.loadProfiles(this);
        if (profiles != null) {
            profileNetworkDataSource.getCurrentProfiles().postValue(profiles);
        }
    }
}
