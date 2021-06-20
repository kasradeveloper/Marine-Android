package com.kasra.atency.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kasra.atency.data.model.LoginResponse
import com.kasra.atency.data.repository.UserRepository
import com.kasra.atency.utility.CLIENTID
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.GRANTTYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {
    private val openNextPageEvent=MutableLiveData<CustomResponse<JSONObject>>()
    val _openNextPageEvent:LiveData<CustomResponse<JSONObject>> = openNextPageEvent
    private val mutableLoginLiveData=MutableLiveData<CustomResponse<LoginResponse?>>()
    val loginLiveData:LiveData<CustomResponse<LoginResponse?>> = mutableLoginLiveData
    fun apiLoginCall(phoneNumber:String, password:String){
        viewModelScope.launch {
            mutableLoginLiveData.postValue(CustomResponse.loading())
            userRepository.loginPostRequest(GRANTTYPE, phoneNumber,password,CLIENTID)
                .collect {
                    mutableLoginLiveData.postValue(it)
                }
        }
    }


}