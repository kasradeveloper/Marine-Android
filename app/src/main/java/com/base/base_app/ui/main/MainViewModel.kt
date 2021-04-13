package com.base.base_app.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.base.base_app.data.AppDataManager

import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
 class MainViewModel @ViewModelInject constructor(
    private val appDataManagerImpl: AppDataManager
):ViewModel(){


}