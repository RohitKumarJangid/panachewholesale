package com.panachewholesale

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri




class UrlActivity : AppCompatActivity() {


    private var progressBar: ProgressBar? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.url_activity)
        progressBar = findViewById(R.id.progress)
        val webView: WebView = findViewById(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                if (url.startsWith("whatsapp://")) {
                    view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                }
                else {
                    progressBar?.visibility = View.VISIBLE
                    view.loadUrl(url)
                }
                return true
            }
            override fun onPageFinished(view: WebView, url: String) {
                progressBar?.visibility=View.GONE
            }
        }
        webView.settings.javaScriptEnabled = true;
        webView.isHorizontalScrollBarEnabled = false;
        webView.settings.setSupportZoom(true);
       // webView.settings.builtInZoomControls = true;
       // webView.settings.displayZoomControls = true;
        webView.loadUrl("https://panachewholesale.com")
    }
}
