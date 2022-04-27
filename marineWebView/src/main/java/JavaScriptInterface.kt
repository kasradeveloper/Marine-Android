package com.kasra.marine.ui.marine

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast


class JavaScriptInterface internal constructor(val c: Context) {
    @JavascriptInterface
    fun showToast(toast: String?) {
        Toast.makeText(c, toast, Toast.LENGTH_SHORT).show()
    }

}