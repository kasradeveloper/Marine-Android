package com.base.bime

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.base.base_app.utility.MyContextWrapper
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp

class BaseApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }





}