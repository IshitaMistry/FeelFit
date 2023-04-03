package com.example.feelfit.Credentials
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.feelfit.Dashboard.Dashboard
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySplashBinding
    lateinit var InsDB: AppDatabase


    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        Handler(Looper.getMainLooper()).postDelayed({
            auth = FirebaseAuth.getInstance()
            var user=auth.currentUser?.email

            if (auth.currentUser != null) {

                startActivity(Intent(applicationContext, Dashboard::class.java))
                finish()
            }
            else {
                startActivity(Intent(this, Login::class.java))
                finish()
            }

        }, 3000)

    }
}