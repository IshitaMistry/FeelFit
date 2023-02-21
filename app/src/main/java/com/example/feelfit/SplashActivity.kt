package com.example.feelfit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.feelfit.databinding.ActivityMainBinding
import com.example.feelfit.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            auth = FirebaseAuth.getInstance()

            if (auth.currentUser != null) {

                startActivity(Intent(applicationContext,Dashboard::class.java))
                finish()
            }
            else {

                startActivity(Intent(this,Login::class.java))
                finish()
            }

        }, 3000)

    }
}