package com.androidifygeeks.sample.di

import com.androidifygeeks.sample.CleanArchApplication
import com.androidifygeeks.sample.di.viewmodel.ViewModelModule
import com.androidifygeeks.sample.ui.InitializationActivity
import com.androidifygeeks.sample.ui.PostDetailFragment
import com.androidifygeeks.sample.ui.PostFragment
import dagger.Component
import javax.inject.Singleton

/**
 * @author ashish on 10,December,2018
 */

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: CleanArchApplication)

    fun inject(launchActivity: InitializationActivity)

    fun inject(postFragment: PostFragment)

    fun inject(postDetailFragment: PostDetailFragment)


}