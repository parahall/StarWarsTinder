package com.android_cademy.starwarstinder.network

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.android_cademy.starwarstinder.model.Profile
import javax.inject.Inject

class ProfileNetworkDataSource @Inject
constructor(val context: Context) {

    val currentProfiles: MutableLiveData<List<Profile>> = MutableLiveData()

    fun startFetchProfiles() {
        val intentToFetch = Intent(context, ProfileFetchService::class.java)
        context.startService(intentToFetch)
    }
}
