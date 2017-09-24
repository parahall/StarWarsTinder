package com.android_cademy.starwarstinder.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import com.android_cademy.starwarstinder.ViewModel.MainViewModelFactory;
import com.android_cademy.starwarstinder.db.AppDatabase;
import com.android_cademy.starwarstinder.model.ProfileRepository;
import com.android_cademy.starwarstinder.network.ProfileNetworkDataSource;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class AppModule {

  private Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Context providesAppContext() {
    return application.getApplicationContext();
  }

  @Provides @Singleton AppDatabase providesDatabase(Context context) {
    return Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class).build();
  }

  @Provides @Singleton ProfileNetworkDataSource providesProfileNetworkSource(Context context) {
    return new ProfileNetworkDataSource(context);
  }

  @Provides @Singleton ProfileRepository providesProfileRepository(AppDatabase appDatabase,
      ProfileNetworkDataSource profileNetworkDataSource) {
    return new ProfileRepository(appDatabase, profileNetworkDataSource);
  }

  @Provides @Singleton MainViewModelFactory providesMainActivityViewModel(
      ProfileRepository profileRepository) {
    return new MainViewModelFactory(profileRepository);
  }
}
