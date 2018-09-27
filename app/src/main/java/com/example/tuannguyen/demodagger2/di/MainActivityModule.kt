package com.example.tuannguyen.demodagger2.di

import com.example.tuannguyen.demodagger2.model.Info
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    fun provideInfo(): Info = Info()
}