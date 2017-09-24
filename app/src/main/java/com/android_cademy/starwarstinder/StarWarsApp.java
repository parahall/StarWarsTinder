package com.android_cademy.starwarstinder;

import android.app.Application;
import com.android_cademy.starwarstinder.di.AppComponent;
import com.android_cademy.starwarstinder.di.AppModule;
import com.android_cademy.starwarstinder.di.DaggerAppComponent;

public class StarWarsApp extends Application {

  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
