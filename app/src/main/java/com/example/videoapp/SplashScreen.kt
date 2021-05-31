package com.example.videoapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val text: TextView = findViewById(R.id.textView)
        val img: ImageView = findViewById(R.id.image1)
        val topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_anim)
        val imgAnim = AnimationUtils.loadAnimation(this,R.anim.image_anim)
        text.startAnimation(topAnimation)
        img.startAnimation(imgAnim)
        val splashTime = 5000
        val home = Intent(this,MainActivity::class.java)
        Handler().postDelayed({
            startActivity(home)
            finish()
        }, splashTime.toLong())
    }
}