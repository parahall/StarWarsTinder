package com.android_cademy.starwarstinder.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.android_cademy.starwarstinder.model.Profile;
import com.android_cademy.starwarstinder.model.ProfileRepository;
import java.util.List;

public class MainViewModel extends ViewModel {

  ProfileRepository profileRepository;

  private LiveData<List<Profile>> profiles;

  MainViewModel(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
    profiles = profileRepository.getProfiles();
  }

  public LiveData<List<Profile>> getProfiles() {
    return profiles;
  }
}
