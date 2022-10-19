package com.kasra.marine

import android.content.Context
import android.webkit.WebView
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.yariksoffice.lingver.Lingver

class Marine : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()
        WebView(this).destroy()
        Lingver.init(this, "fa")

    }

}