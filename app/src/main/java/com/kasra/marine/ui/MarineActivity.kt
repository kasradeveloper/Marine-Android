package com.kasra.marine.ui

import android.os.Build
import android.os.Bundle
import com.example.bilerplatemvvm.R
import android.util.Log
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.kasra.marine.ui.marine.MarineWebView

class MarineActivity : AppCompatActivity() {
    private lateinit var webView: MarineWebView
    private var webSettings: WebSettings? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marine)
        initView()
    }

    private fun initView() {
        webView = findViewById(R.id.web_view)
        webView.initWebView(this, "https://www.google.com/")
    }
}