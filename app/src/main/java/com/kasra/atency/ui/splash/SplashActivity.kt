package com.kasra.atency.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.bilerplatemvvm.R
import com.kasra.atency.ui.base.BaseActivity
import com.kasra.atency.utility.enums.ActivityName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity :BaseActivity(R.layout.activity_splash){
    private val splashViewModel:SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeItems()
        splashViewModel.getIsLogin()
    }
    override fun observeItems() {
        splashViewModel.isLogin.observe(this,{
            Handler(Looper.getMainLooper()).postDelayed({
                if(it){
                    openActivity(ActivityName.MAINACTIVITY)
                }else{
                    openActivity(ActivityName.LOGINACTIVITY)
                }
            }, 1000)
        })
    }
}