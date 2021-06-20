package com.kasra.atency.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.bilerplatemvvm.R
import com.kasra.atency.ui.base.BaseActivity
import com.kasra.atency.utility.CustomResponse
import com.kasra.atency.utility.PLUS
import com.kasra.atency.utility.changeSolidColor
import com.kasra.atency.utility.enums.ActivityName
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity(R.layout.activity_login) {
    private val loginViewModel:LoginViewModel by viewModels()
    @Inject
    lateinit var  bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeSolidColor(btn_login, ContextCompat.getColor(this, R.color.colorSuccess))
        observeItems()
        btn_login.setOnClickListener{
            if(phone_number_txt.text.toString().trim().isEmpty()||password_txt.text.toString().trim().isEmpty()) {
                showErrorMessage(getString(R.string.empty_login))
                return@setOnClickListener
            }
            if (phone_number_txt.text.toString().trim()[0] == '0') {
                    phone_number_txt.text.toString().substring(1)
            }
            val pgoneNumber=PLUS+ccp.selectedCountryCode +phone_number_txt.text.toString().trim()
            loginViewModel.apiLoginCall(pgoneNumber, password_txt.text.toString().trim())
        }
    }

    override fun observeItems(){
        loginViewModel.loginLiveData.observe(this, {
            when (it.status) {
                CustomResponse.Status.LOADING -> btn_login.startAnimation()
                CustomResponse.Status.FAIL, CustomResponse.Status.ERROR -> {
                    btn_login.revertAnimation()
                    it.message?.let { error ->
                        showErrorMessage(
                            error
                        )
                    }
                }
                CustomResponse.Status.SUCCESS -> {
                    btn_login.revertAnimation()
                    openActivity (ActivityName.MAINACTIVITY)
                }
            }
        })
    }
}