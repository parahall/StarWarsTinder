package com.android_cademy.starwarstinder.di;

import com.android_cademy.starwarstinder.View.MainActivity;
import com.android_cademy.starwarstinder.network.ProfileFetchService;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { AppModule.class }) public interface AppComponent {

  void inject(MainActivity mainActivity);

  void inject(ProfileFetchService profileFetchService);
}
