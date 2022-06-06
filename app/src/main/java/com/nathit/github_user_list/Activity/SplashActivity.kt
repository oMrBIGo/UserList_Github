package com.nathit.github_user_list.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nathit.github_user_list.R

class SplashActivity : AppCompatActivity() {

    var progressBar: ProgressBar? = null
    var valueText: TextView? = null
    var value = 0
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progressBar_splash)
        valueText = findViewById<View>(R.id.valueText) as TextView

        /* Animation Show */
        val animation: Animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 200
        animation.startOffset = 50
        animation.repeatMode = Animation.REVERSE
        animation.repeatCount = Animation.INFINITE
        valueText!!.startAnimation(animation)

        /* [Enable]Start ProgressBar */
        val thread = Thread { startProgress() }
        thread.start()

    }

    /* Start Progress Bar */
    fun startProgress() {
        value = 0
        while (value <= 99) {
            try {
                Thread.sleep(15)
                progressBar!!.progress = value
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            handler.post { valueText!!.text = "$value%" }
            value = value + 1
        }
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}