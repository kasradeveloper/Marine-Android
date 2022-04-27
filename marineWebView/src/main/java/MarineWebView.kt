package com.kasra.marine.ui.marine

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MarineWebView : WebView {

    lateinit var onPageFinish: ((WebView, String) -> Unit)
    private lateinit var appCompatActivity: AppCompatActivity
    private lateinit var loadUrl: String

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(appCompatActivity: AppCompatActivity, loadUrl: String) {
        this.appCompatActivity = appCompatActivity
        this.loadUrl = loadUrl
        val webView = this
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.allowFileAccess = true
        webView.webViewClient = MyClient(onPageFinish = { view, url ->
            onPageFinish(view, url)
        })
        webView.webChromeClient = MyChromClient(context, appCompatActivity)
        webView.addJavascriptInterface(JavaScriptInterface(context), "AndroidFunction")
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else if (Build.VERSION.SDK_INT < 19) {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
        webView.loadUrl(loadUrl)
    }

}