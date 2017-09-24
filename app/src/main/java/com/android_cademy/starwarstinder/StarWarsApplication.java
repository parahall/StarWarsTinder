package com.android_cademy.starwarstinder;

import android.app.Application;
import com.android_cademy.starwarstinder.di.AppModule;

/**
 * Created by yoni_levin on 24/09/2017.
 */

public class StarWarsApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }
}
