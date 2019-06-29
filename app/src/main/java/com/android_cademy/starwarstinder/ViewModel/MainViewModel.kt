package com.android_cademy.starwarstinder.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.android_cademy.starwarstinder.model.Profile
import com.android_cademy.starwarstinder.model.ProfileRepository

class MainViewModel internal constructor(internal var profileRepository: ProfileRepository) : ViewModel() {

    val profiles: LiveData<List<Profile>>

    init {
        profiles = profileRepository.profiles
    }
}
