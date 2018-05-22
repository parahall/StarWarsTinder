package com.android_cademy.starwarstinder.network;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;

import com.android_cademy.starwarstinder.model.Profile;

import java.util.List;

import javax.inject.Inject;

public class ProfileNetworkDataSource {

    private final MutableLiveData<List<Profile>> mDownloadedProfiles;
    private Context context;

    @Inject
    public ProfileNetworkDataSource(Context context) {
        this.context = context;
        mDownloadedProfiles = new MutableLiveData<>();
    }

    public void startFetchProfiles() {
        Intent intentToFetch = new Intent(context, ProfileFetchService.class);
        context.startService(intentToFetch);
    }

    public MutableLiveData<List<Profile>> getCurrentProfiles() {
        return mDownloadedProfiles;
    }
}
