package com.android_cademy.starwarstinder.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.android_cademy.starwarstinder.model.ProfileRepository

class MainViewModelFactory(private val mRepository: ProfileRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(mRepository) as T
    }

    //    @Override
    //    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    //
    //    }
}