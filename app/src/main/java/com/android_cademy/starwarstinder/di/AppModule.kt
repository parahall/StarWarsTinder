package com.android_cademy.starwarstinder.di

import android.app.Application
import androidx.room.Room
import android.content.Context

import com.android_cademy.starwarstinder.ViewModel.MainViewModelFactory
import com.android_cademy.starwarstinder.db.AppDatabase
import com.android_cademy.starwarstinder.model.ProfileRepository
import com.android_cademy.starwarstinder.network.ProfileNetworkDataSource

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesAppContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesDatabase(context: Context): AppDatabase {
        return Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
                .build()
    }

    @Provides
    @Singleton
    fun providesProfileNetworkSource(context: Context): ProfileNetworkDataSource {
        return ProfileNetworkDataSource(context)
    }

    @Provides
    @Singleton
    fun providesProfileRepository(appDatabase: AppDatabase,
                                           profileNetworkDataSource: ProfileNetworkDataSource): ProfileRepository {
        return ProfileRepository(appDatabase, profileNetworkDataSource)
    }

    @Provides
    @Singleton
    fun providesMainActivityViewModel(
            profileRepository: ProfileRepository): MainViewModelFactory {
        return MainViewModelFactory(profileRepository)
    }
}
