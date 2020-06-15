package com.panachewholesale

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
           /* val url = "https://panachewholesale.com"
            val builder = CustomTabsIntent.Builder().enableUrlBarHiding()
            builder.setStartAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out);
            builder.setExitAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out);
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(this, Uri.parse(url))*/
            startActivity(Intent(this,UrlActivity::class.java))
            finish()
        },2000)


    }
}
