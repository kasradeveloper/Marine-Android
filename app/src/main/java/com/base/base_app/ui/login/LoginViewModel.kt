package com.base.base_app.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.base_app.data.AppDataManager
import com.base.bime.data.model.LoginModel
import com.base.base_app.utility.CustomResponse

import kotlinx.coroutines.launch
import org.json.JSONObject

class LoginViewModel @ViewModelInject constructor(private val appDataManager: AppDataManager):ViewModel() {
    private val openNextPageEvent=MutableLiveData<CustomResponse<JSONObject>>()
    val _openNextPageEvent:LiveData<CustomResponse<JSONObject>>
        get() = openNextPageEvent
    private val loginLiveData=MutableLiveData<CustomResponse<LoginModel>>()
    val _loginLiveData:LiveData<CustomResponse<LoginModel>>
        get() = loginLiveData
    fun loginOrRegister(phoneNumber:String){
        viewModelScope.launch {
            appDataManager.loginOrRegister(phoneNumber).let {
                openNextPageEvent.postValue(it)
            }
        }
    }
    fun apiLoginCall(phoneNumber:String, password:String){
        viewModelScope.launch {
            appDataManager.loginApiCall(phoneNumber,password).let {
                loginLiveData.postValue(it)
            }
        }
    }
    fun getIslogined()=appDataManager.getIslogined()


}