package com.android_cademy.starwarstinder.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android_cademy.starwarstinder.R;
import com.android_cademy.starwarstinder.StarWarsApp;
import com.android_cademy.starwarstinder.ViewModel.MainViewModel;
import com.android_cademy.starwarstinder.ViewModel.MainViewModelFactory;
import com.android_cademy.starwarstinder.model.Profile;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Observer<List<Profile>> {

    @Inject
    MainViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((StarWarsApp) getApplicationContext()).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        mainViewModel.getProfiles().observe(this, this);
    }

    @Override
    public void onChanged(@Nullable List<Profile> profiles) {
        TextView view = findViewById(R.id.tv);
        if (profiles != null) {
            for (Profile profile : profiles) {
                view.append("\n" + profile.getName());
            }
        }
    }
}
