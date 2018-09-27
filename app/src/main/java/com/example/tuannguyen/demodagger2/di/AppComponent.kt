package com.example.tuannguyen.demodagger2.di

import android.app.Application
import com.example.tuannguyen.demodagger2.DemoDaggerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(modules = [AppModule::class, AppActivityBindingModule::class, AndroidInjectionModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(application: DemoDaggerApplication)
}