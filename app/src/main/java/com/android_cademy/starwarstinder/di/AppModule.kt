package com.android_cademy.starwarstinder.di

import android.app.Application
import android.content.Context
import com.android_academy.db.AppDatabase
import com.android_academy.db.DbBuilder
import com.android_cademy.starwarstinder.model.ProfileRepository
import com.android_academy.network.ProfileNetworkDataSource
import com.android_cademy.starwarstinder.viewModel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
        return DbBuilder.Builder(context).build()
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
