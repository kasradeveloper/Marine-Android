package com.base.base_app.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.base_app.data.AppDataManager
import com.base.base_app.data.model.BaseModel
import com.base.base_app.utility.CustomResponse
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(val appDataManager: AppDataManager) :ViewModel() {
    private val vehicleInsurancePoliocy = MutableLiveData<CustomResponse<List<BaseModel>>>()
    val _VehicleInsurancePolicy: LiveData<CustomResponse<List<BaseModel>>>
        get() = vehicleInsurancePoliocy

    fun getVehicleInsurancePolicy() = viewModelScope.launch {
        appDataManager.getVehicleInsurancePolicy().let {
            vehicleInsurancePoliocy.postValue(it)

        }
    }
}