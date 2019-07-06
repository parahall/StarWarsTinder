package com.android_cademy.starwarstinder.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.android_cademy.starwarstinder.model.ProfileRepository

class MainViewModelFactory(private val mRepository: ProfileRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(mRepository) as T
    }
}