package com.android_cademy.starwarstinder.network

import android.app.IntentService
import android.content.Intent

import com.android_cademy.starwarstinder.ResourcesUtil
import com.android_cademy.starwarstinder.StarWarsApp

import javax.inject.Inject

class ProfileFetchService : IntentService("ProfileFetchService") {

    @Inject
    lateinit var profileNetworkDataSource: ProfileNetworkDataSource

    override fun onHandleIntent(intent: Intent?) {
        (applicationContext as StarWarsApp).appComponent.inject(this)

        val profiles = ResourcesUtil.loadProfiles(this)
        if (profiles != null) {
            profileNetworkDataSource.networkProfiles.postValue(profiles)
        }
    }
}
