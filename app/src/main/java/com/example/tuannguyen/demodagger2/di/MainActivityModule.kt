package com.example.tuannguyen.demodagger2.di

import com.example.tuannguyen.demodagger2.model.Info
import com.example.tuannguyen.demodagger2.model.InfoInterface
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {
    @Binds
    abstract fun provideInfo(info: Info): InfoInterface
}