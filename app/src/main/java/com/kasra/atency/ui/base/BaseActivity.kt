package com.kasra.atency.ui.base

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bilerplatemvvm.R
import com.kasra.atency.ui.login.LoginActivity
import com.kasra.atency.ui.main.MainActivity
import com.kasra.atency.ui.modules.duty.DutyFragment
import com.kasra.atency.ui.modules.home.HomeFragment
import com.kasra.atency.ui.modules.message.MessageFragment
import com.kasra.atency.ui.modules.performance.PerformanceFragment
import com.kasra.atency.ui.modules.portfolio.PortfolioFragment
import com.kasra.atency.ui.modules.request.RequestFragment
import com.kasra.atency.ui.modules.subordinate.SubordinateFragment
import com.kasra.atency.ui.modules.ticket.TicketFragment
import com.kasra.atency.utility.MyContextWrapper
import com.kasra.atency.utility.enums.ActivityName
import com.kasra.atency.utility.enums.FragmentName
import com.muddzdev.styleabletoastlibrary.StyleableToast
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
abstract class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(MyContextWrapper.wrap(newBase, Locale("fa")))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            changeStatusColor()
        }
    }
    open fun showErrorMessage(message:String){
        StyleableToast.Builder(this)
            .text(message)
            .textColor(ContextCompat.getColor(this,R.color.colorwhite))
            .backgroundColor(ContextCompat.getColor(this,R.color.colorRedToast))
            .iconStart(R.drawable.ic_cancle_circle)
            .font(R.font.dana_fa_medium)
            .show()
    }
    open fun showMessage(message:String){
        StyleableToast.Builder(this)
            .text(message)
            .textColor(ContextCompat.getColor(this,R.color.colorwhite))
            .backgroundColor(ContextCompat.getColor(this,R.color.colorGreenToast))
            .iconStart(R.drawable.ic_check_circle)
            .font(R.font.dana_fa_medium)
            .show()
    }
    abstract fun observeItems()
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    open fun changeStatusColor() {
        val window = window
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    // finally change the color
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
    }
    fun openActivity(activityName:ActivityName,bundle: Bundle?=null){
        when(activityName){
            ActivityName.MAIN->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            ActivityName.LOGIN ->{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    fun showNextFragment(fragmentName:FragmentName,bundle: Bundle?=null,layout:Int){
        when (fragmentName){
            FragmentName.HOME->supportFragmentManager.beginTransaction().add(layout, HomeFragment(), "home_fragment").commitAllowingStateLoss()
            FragmentName.PERFORMANCE->supportFragmentManager.beginTransaction().add(layout, PerformanceFragment(), "performance_fragment").commitAllowingStateLoss()
            FragmentName.SUBORDINATE->supportFragmentManager.beginTransaction().add(layout, SubordinateFragment(), "subordinate_fragment").commitAllowingStateLoss()
            FragmentName.REQUEST->supportFragmentManager.beginTransaction().add(layout, RequestFragment(), "request_fragment").commitAllowingStateLoss()
            FragmentName.PORTFOLIO->supportFragmentManager.beginTransaction().add(layout, PortfolioFragment(), "portfolio_fragment").commitAllowingStateLoss()
            FragmentName.MESSAGER->supportFragmentManager.beginTransaction().add(layout, MessageFragment(), "message_fragment").commitAllowingStateLoss()
            FragmentName.TICKET->supportFragmentManager.beginTransaction().add(layout, TicketFragment(), "ticket_fragment").commitAllowingStateLoss()
            FragmentName.DUTY->supportFragmentManager.beginTransaction().add(layout, DutyFragment(), "duty_fragment").commitAllowingStateLoss()
        }
    }

}






