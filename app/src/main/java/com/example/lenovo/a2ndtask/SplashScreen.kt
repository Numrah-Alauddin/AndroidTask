package com.example.lenovo.a2ndtask

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logo = findViewById<ImageView>(R.id.logo_img)

        val progress1 = findViewById<ImageView>(R.id.progress1)
        val progress2 = findViewById<ImageView>(R.id.progress2)
        val progress3 = findViewById<ImageView>(R.id.progress3)
        val progress4 = findViewById<ImageView>(R.id.progress4)
        val progress5 = findViewById<ImageView>(R.id.progress5)

        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        val progressAnimation1 = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        val progressAnimation2 = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        val progressAnimation3 = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        val progressAnimation4 = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        val progressAnimation5 = AnimationUtils.loadAnimation(this, R.anim.logo_animation)

        progressAnimation1.startOffset = 300
        progressAnimation2.startOffset = 400
        progressAnimation3.startOffset = 500
        progressAnimation4.startOffset = 600
        progressAnimation5.startOffset = 700

        logo.startAnimation(animation)

        progress1.startAnimation(progressAnimation1)
        progress2.startAnimation(progressAnimation2)
        progress3.startAnimation(progressAnimation3)
        progress4.startAnimation(progressAnimation4)
        progress5.startAnimation(progressAnimation5)

        progressAnimation1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {

                startActivity(Intent(this@SplashScreen,MainActivity::class.java))
                finish()
            }

            override fun onAnimationStart(p0: Animation?) {
            }
        })
    }
}
