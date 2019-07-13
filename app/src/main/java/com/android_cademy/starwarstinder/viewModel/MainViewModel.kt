package com.android_cademy.starwarstinder.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import com.android_cademy.starwarstinder.model.ProfileRepository

class MainViewModel internal constructor(profileRepository: ProfileRepository) : ViewModel() {

    private val _uiProfiles: MutableLiveData<List<com.android_academy.db.Profile>> = MutableLiveData()
    val uiProfiles: LiveData<List<com.android_academy.db.Profile>> = _uiProfiles

    val repositoryProfiels: LiveData<List<com.android_academy.db.Profile>> = profileRepository.profiles

    private val observer = Observer<List<com.android_academy.db.Profile>> {
        _uiProfiles.postValue(it)
    }

    init {
        repositoryProfiels.observeForever(observer)
    }

    override fun onCleared() {
        repositoryProfiels.removeObserver(observer)
    }
}
