package com.android_cademy.starwarstinder.model

import androidx.lifecycle.LiveData

import com.android_academy.network.ProfileNetworkDataSource

import javax.inject.Inject

class ProfileRepository @Inject
constructor(private val db: com.android_academy.db.AppDatabase, private val profileNetworkDataSource: ProfileNetworkDataSource) {

    val profiles: LiveData<List<com.android_academy.db.Profile>>
        get() {
            return db.profileDao().getAll()
        }

    private val isFetchNeeded: Boolean
        get() {
            val count = db.profileDao().countProfiles()
            return count <= MIN_PROFILES_TO_CACHE
        }

    init {
        val networkData = profileNetworkDataSource.networkProfiles
        networkData.observeForever { profilesFromNetwork ->
            Thread {
                deleteOldData()
                val profile = profilesFromNetwork.toTypedArray()
                db.profileDao().bulkInsert(*profile)
            }.start()
        }
        fetchData()
    }

    private fun deleteOldData() {
        db.profileDao().deleteProfiles()
    }

    private fun fetchData() {
        //regular thread is used to simplify the example. don't do that in the production :)
        Thread {
            if (isFetchNeeded) {
                startFetchProfilesService()
            }
        }.start()
    }

    private fun startFetchProfilesService() {
        profileNetworkDataSource.startFetchProfiles()
    }

    companion object {
        private val MIN_PROFILES_TO_CACHE = 10
    }
}
