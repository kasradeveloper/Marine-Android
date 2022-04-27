package com.kasra.marine.ui.marine

import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import java.lang.Exception

class MyClient(private val onPageFinish: (view: WebView, url: String) -> Unit) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        // If url contains mailto link then open Mail Intent
        return if (url.contains("mailto:")) {
            // Could be cleverer and use a regex
            //Open links in new browser
            view.context.startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse(url))
            )
            // Here we can open new activity
            true
        } else {
            // Stay within this webview and load url
            view.loadUrl(url)
            true
        }
    }

    // Called when all page resources loaded
    override fun onPageFinished(view: WebView, url: String) {
        try {
            onPageFinish(view, url)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}