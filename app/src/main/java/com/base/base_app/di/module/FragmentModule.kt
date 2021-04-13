package com.base.base_app.di.module

import com.base.base_app.data.model.InquiryModel
import com.base.base_app.data.model.Vehicle

import com.base.base_app.ui.main.wallet.TransactionAdapter

import com.base.base_app.ui.main.home.InsurancesAdapter
import com.base.base_app.ui.main.insurance_history.InsuranceListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    @Provides
    fun provideInsuranceListAdapter()= InsuranceListAdapter(arrayListOf())
    @Provides
    fun provideTransactionAdapter()=TransactionAdapter(arrayListOf())
    @Provides
    fun provideInsuranceAdapter()= InsurancesAdapter(arrayListOf())
    @Provides
    fun provideVehicleModel()=Vehicle()
    @Provides
    fun provideInquiryModel()=InquiryModel()





}