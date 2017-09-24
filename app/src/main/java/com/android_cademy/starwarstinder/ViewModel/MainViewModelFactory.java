package com.android_cademy.starwarstinder.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.android_cademy.starwarstinder.model.ProfileRepository;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {

  private final ProfileRepository mRepository;

  public MainViewModelFactory(ProfileRepository repository) {
    this.mRepository = repository;
  }

  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
    //noinspection unchecked
    return (T) new MainViewModel(mRepository);
  }
}