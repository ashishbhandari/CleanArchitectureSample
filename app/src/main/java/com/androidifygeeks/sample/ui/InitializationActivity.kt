package com.androidifygeeks.sample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidifygeeks.sample.CleanArchApplication
import com.androidifygeeks.sample.di.ApplicationComponent
import com.androidifygeeks.sample.manager.NavigationManager
import javax.inject.Inject
import javax.inject.Singleton

class InitializationActivity : AppCompatActivity() {


    @Inject
    @Singleton
    lateinit var navigationManager: NavigationManager


    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as CleanArchApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        navigationManager.navigateToMain(this)

    }
}
