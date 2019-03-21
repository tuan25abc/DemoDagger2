package com.example.tuannguyen.demodagger2

import android.app.Activity
import android.app.Application
import com.example.tuannguyen.demodagger2.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DemoDaggerApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroid: DispatchingAndroidInjector<Activity>

    lateinit var activityInjector: AndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().application(this).build().inject(this)

        activityInjector = activityDispatchingAndroid
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}