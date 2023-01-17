package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val handler = Handler()
        handler.postDelayed({
            auth = FirebaseAuth.getInstance()

            if (auth.currentUser != null) {

                startActivity(Intent(applicationContext,DashBoard::class.java))
                finish()
            }else{
                startActivity(Intent(this, LoginActivityFF::class.java))
                finish()
            }

        },2000)
    }
}