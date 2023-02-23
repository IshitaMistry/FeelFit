package com.example.feelfit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.feelfit.databinding.ActivityMainBinding
import com.example.feelfit.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    lateinit var InsDB: AppDatabase

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            auth = FirebaseAuth.getInstance()
            var user=auth.currentUser?.email

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