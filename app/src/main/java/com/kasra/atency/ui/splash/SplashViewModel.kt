package com.kasra.atency.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kasra.atency.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {
    private val mutableIsLogin:MutableLiveData<Boolean> = MutableLiveData()
    val isLogin:LiveData<Boolean> = mutableIsLogin
    fun getIsLogin(){
        mutableIsLogin.postValue(userRepository.getIsLogin())
    }

}