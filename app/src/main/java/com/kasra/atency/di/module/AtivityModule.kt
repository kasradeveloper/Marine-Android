package com.kasra.atency.di.module

import android.os.Bundle

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class AtivityModule {
    @Provides
    fun provideBundle()= Bundle()
//    @Provides
//    fun provideVehicleUsageAdapter()= VehicleUsageAdapter(arrayListOf())


}