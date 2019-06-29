package com.android_cademy.starwarstinder.di

import com.android_cademy.starwarstinder.View.MainActivity
import com.android_cademy.starwarstinder.network.ProfileFetchService

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(profileFetchService: ProfileFetchService)
}
