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
    fun initWebView(
        appCompatActivity: AppCompatActivity,
        loadUrl: String,
        onReciveData: ((String?) -> Unit)? = null
    ) {
        this.appCompatActivity = appCompatActivity
        this.loadUrl = loadUrl
        val webView = this
        setWebContentsDebuggingEnabled(true)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.allowFileAccess = true
        webView.webViewClient = MyClient(onPageFinish = { view, url ->
            onPageFinish(view, url)
        })
        webView.webChromeClient = MyChromClient(context, appCompatActivity)
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