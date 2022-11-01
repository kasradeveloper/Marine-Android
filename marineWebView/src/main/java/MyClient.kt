package com.kasra.marine.ui.marine

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.webkit.*
import androidx.annotation.RequiresApi
import java.lang.Exception

class MyClient(
    private val onPageFinish: (view: WebView, url: String) -> Unit,
    private val onError: (WebViewClientError) -> Unit
) : WebViewClient() {

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


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        onError(WebViewClientError.GeneralError(view, request, error))
        super.onReceivedError(view, request, error)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onReceivedHttpError(
        view: WebView?,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        onError(WebViewClientError.HttpError(view, request, errorResponse))
        super.onReceivedHttpError(view, request, errorResponse)
    }

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        onError(WebViewClientError.SslError(view, handler, error))
        super.onReceivedSslError(view, handler, error)
    }

    sealed class WebViewClientError {
        class HttpError(
            val view: WebView?,
            val request: WebResourceRequest?,
            val errorResponse: WebResourceResponse?
        ) : WebViewClientError()

        class SslError(
            val view: WebView?,
            val handler: SslErrorHandler?,
            val error: android.net.http.SslError?
        ) : WebViewClientError()

        class GeneralError(
            val view: WebView?,
            val request: WebResourceRequest?,
            val error: WebResourceError?
        ) :
            WebViewClientError()
    }
}