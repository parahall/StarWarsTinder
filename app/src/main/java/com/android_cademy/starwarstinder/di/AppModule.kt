package com.android_cademy.starwarstinder.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.android_cademy.starwarstinder.viewModel.MainViewModelFactory
import com.android_cademy.starwarstinder.db.AppDatabase
import com.android_cademy.starwarstinder.model.ProfileRepository
import com.android_cademy.starwarstinder.network.ProfileNetworkDataSource
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
        val db = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "profiles_db").build()
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "profiles_db")
//        return Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
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
