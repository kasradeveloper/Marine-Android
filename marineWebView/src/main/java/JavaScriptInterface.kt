package com.kasra.marine.ui.marine

import android.webkit.JavascriptInterface

class JavaScriptInterface internal constructor(
    private val onReciveData: ((data: String?) -> Unit)?
) {
    @JavascriptInterface
    fun showToast(s: String?) {
        onReciveData?.let { it(s) }
    }
    @JavascriptInterface
    fun isValid(b:String?) {
        onReciveData?.let { it(b) }
    }
}