package com.android_cademy.starwarstinder.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

import com.android_cademy.starwarstinder.R
import com.android_cademy.starwarstinder.StarWarsApp
import com.android_cademy.starwarstinder.viewModel.MainViewModel
import com.android_cademy.starwarstinder.viewModel.MainViewModelFactory
import com.android_cademy.starwarstinder.model.Profile

import javax.inject.Inject

class MainActivity : AppCompatActivity(), Observer<List<Profile>> {

    @Inject
    lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as StarWarsApp).appComponent.inject(this)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        mainViewModel.uiProfiles.observe(this, this)
    }

    override fun onChanged(profiles: List<Profile>?) {
        val view = findViewById<TextView>(R.id.tv)
        if (profiles != null) {
            for (profile in profiles) {
                view.append("\n" + profile.name)
            }
        }
    }
}
