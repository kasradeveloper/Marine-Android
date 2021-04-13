package com.base.base_app.ui.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.base.base_app.utility.MyContextWrapper
import com.example.bilerplatemvvm.R
import com.muddzdev.styleabletoastlibrary.StyleableToast
import java.util.*

open class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            changeStatusColor()
        }
    }
    open fun showErrorMessage(message:String){
        StyleableToast.Builder(this)
            .text(message)
            .textColor(ContextCompat.getColor(this,R.color.colorwhite))
            .backgroundColor(ContextCompat.getColor(this,R.color.colorRedToast))
            .iconStart(R.drawable.ic_toast_cancel)
            .font(R.font.dana_fa_medium)
            .show()
    }
    open fun showMessage(message:String){
        StyleableToast.Builder(this)
            .text(message)
            .textColor(ContextCompat.getColor(this,R.color.colorwhite))
            .backgroundColor(ContextCompat.getColor(this,R.color.colorGreenToast))
            .iconStart(R.drawable.ic_baseline_check_circle_24)
            .font(R.font.dana_fa_medium)
            .show()
    }

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
    open fun initGridRecycler(recyclerView: RecyclerView): RecyclerView {
        recyclerView.layoutManager = GridLayoutManager(this,3)
        return recyclerView
    }
    open fun initVerticalRecycler(recyclerView: RecyclerView): RecyclerView {
        recyclerView.layoutManager = LinearLayoutManager(this)
        return recyclerView
    }
}






