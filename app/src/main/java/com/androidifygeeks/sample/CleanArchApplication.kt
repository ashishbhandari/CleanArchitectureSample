package com.androidifygeeks.sample

import android.app.Application
import com.androidifygeeks.sample.di.ApplicationComponent
import com.androidifygeeks.sample.di.ApplicationModule
import com.androidifygeeks.sample.di.DaggerApplicationComponent

/**
 * @author ashish on 10,December,2018
 */
class CleanArchApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}