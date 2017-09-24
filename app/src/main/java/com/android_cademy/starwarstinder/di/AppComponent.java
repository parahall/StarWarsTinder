package com.android_cademy.starwarstinder.di;

import com.academy.android.starwarsmovies.model.StarWarsService;
import com.academy.android.starwarsmovies.view.LoginActivity;
import com.academy.android.starwarsmovies.viewmodel.LoginViewModel;
import com.academy.android.starwarsmovies.viewmodel.MainViewModel;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { AppModule.class }) public interface AppComponent {

  //void inject(MainViewModel mainViewModel);
}
