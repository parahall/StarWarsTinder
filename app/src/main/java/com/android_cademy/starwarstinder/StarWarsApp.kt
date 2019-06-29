package com.android_cademy.starwarstinder

import android.app.Application

import com.android_cademy.starwarstinder.di.AppComponent
import com.android_cademy.starwarstinder.di.AppModule
import com.android_cademy.starwarstinder.di.DaggerAppComponent

class StarWarsApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
