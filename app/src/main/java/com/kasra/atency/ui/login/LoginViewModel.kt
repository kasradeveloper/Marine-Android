package com.kasra.atency.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kasra.atency.data.model.LoginResponse
import com.kasra.atency.data.model.workplace.WorkplaceModel
import com.kasra.atency.data.repository.user.UserRepository
import com.kasra.atency.data.repository.workplace.WorkPlaceRepository
import com.kasra.atency.utility.CLIENTID
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.GRANTTYPE
import com.kasra.atency.utility.WORKPLACETYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository,val workPlaceRepository: WorkPlaceRepository):ViewModel() {
    private val mutableWorkplace=MutableLiveData<CustomResponse<List<WorkplaceModel?>?>>()
    val workplace:LiveData<CustomResponse<List<WorkplaceModel?>?>> = mutableWorkplace
    private val mutableLoginLiveData=MutableLiveData<CustomResponse<LoginResponse?>>()
    val loginLiveData:LiveData<CustomResponse<LoginResponse?>> = mutableLoginLiveData
    fun apiLoginCall(phoneNumber:String, password:String){
        viewModelScope.launch {
            mutableLoginLiveData.postValue(CustomResponse.loading())
            userRepository.loginPostRequest(GRANTTYPE, phoneNumber,password,CLIENTID)
                .collect {
                    mutableLoginLiveData.postValue(it)
                    if(it.status==CustomResponse.Status.SUCCESS){
                        getAllWorkPlaces()
                    }
                }
        }
    }
    private fun getAllWorkPlaces(){
        viewModelScope.launch {
            workPlaceRepository.getWorkplaces(WORKPLACETYPE)
                .collect {
                    mutableWorkplace.postValue(it)
                }
        }
    }


}