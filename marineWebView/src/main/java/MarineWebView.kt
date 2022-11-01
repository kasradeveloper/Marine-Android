package com.kasra.marine.ui.marine

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MarineWebView : WebView {

    lateinit var onPageFinish: ((WebView, String) -> Unit)

    private lateinit var appCompatActivity: AppCompatActivity
    private lateinit var loadUrl: String

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(
        appCompatActivity: AppCompatActivity,
        loadUrl: String,
        onError: (MyClient.WebViewClientError) -> Unit,
        onReciveData: ((String?) -> Unit)? = null,
    ) {
        this.appCompatActivity = appCompatActivity
        this.loadUrl = loadUrl
        val webView = this
        setWebContentsDebuggingEnabled(true)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.allowFileAccess = true


        webView.webViewClient = MyClient(
            onPageFinish = { view, url ->
                onPageFinish(view, url)
            }, onError = onError
        )
        webView.webChromeClient = MyChromeClient(context, appCompatActivity)
        webView.addJavascriptInterface(
            JavaScriptInterface(onReciveData),
            "AndroidFunction"
        )
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView.loadUrl(loadUrl)
    }

    fun callJsFunction(functionName: String, values: List<String> = arrayListOf()) {
        val functionValues = values.joinToString(",")
        loadUrl("javascript:($functionName($functionValues))")
    }

}