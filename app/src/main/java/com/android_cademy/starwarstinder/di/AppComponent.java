package com.android_cademy.starwarstinder.di;

import com.android_cademy.starwarstinder.View.MainActivity;
import com.android_cademy.starwarstinder.network.ProfileFetchService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(ProfileFetchService profileFetchService);
}
