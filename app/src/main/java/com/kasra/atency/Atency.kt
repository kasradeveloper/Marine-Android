package com.kasra.atency

import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import io.sentry.android.core.SentryAndroid
import io.sentry.android.core.SentryAndroidOptions

@HiltAndroidApp

class Atency : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            SentryAndroid.init(
                this
            ) { options: SentryAndroidOptions ->
                options.environment = "DEBUG"
            }
        } else {
            SentryAndroid.init(
                this
            ) { options: SentryAndroidOptions ->
                options.environment = "Production"
            }
        }
    }

}