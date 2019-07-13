package com.android_academy.network

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ProfileNetworkDataSource @Inject
constructor(val context: Context) {

    val networkProfiles: MutableLiveData<List<Profile>> = MutableLiveData()

    fun startFetchProfiles() {
        val intentToFetch = Intent(context, ProfileFetchService::class.java)
        context.startService(intentToFetch)
    }
}
