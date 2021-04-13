package com.base.base_app.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import com.base.base_app.ui.base.BaseActivity
import com.base.base_app.ui.main.MainActivity
import com.base.base_app.utility.CustomResponse
import com.example.bilerplatemvvm.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.login_activity.*
import javax.inject.Inject
@AndroidEntryPoint
class LoginActivity : BaseActivity(R.layout.login_activity) {
    private val loginViewModel:LoginViewModel by viewModels()
    @Inject
    lateinit var  bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            openMainPage()    }
    private fun openNextPage(){
//        bundle.putString("phone_number",phone_number_edit_txt.text.toString())
//        verificationCode.arguments=bundle
//        supportFragmentManager.beginTransaction().add(R.id.main_login_layout,verificationCode,"verification_code").addToBackStack(null).commitAllowingStateLoss()
    }
    fun openMainPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}