package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lateinit var InsDB: AppDatabase

        val handler = Handler()
        handler.postDelayed({
            auth = FirebaseAuth.getInstance()
            var user=auth.currentUser?.email

            if (auth.currentUser != null) {

                InsDB = AppDatabase.getDatabase(this@SplashScreenActivity)
                GlobalScope.launch(Dispatchers.IO) {

                    val enties = user?.let { InsDB.userInfoDao().getAll(it) }
                    Log.e("hello", "Shubh: $enties" + "" )
                    launch(Dispatchers.Main) {

                        var body= enties?.get(0)?.body.toString()
                        Log.e("sahil", "=========>:$body ", )
                        if (body=="Severe Skinny")
                        {
                            startActivity(Intent(applicationContext,GainingActivity::class.java))
                        }
                        else if (body=="Moderate Skinny")
                        {
                            startActivity(Intent(applicationContext,GainingActivity::class.java))

                        }else if (body== "Moderate Skinny")
                        {
                            startActivity(Intent(applicationContext,GainingActivity::class.java))

                        }else if (body=="Mild Thinness")
                        {
                            startActivity(Intent(applicationContext,GainingActivity::class.java))

                        }




                    }
                    }




                    startActivity(Intent(applicationContext,DashBoard::class.java))
                finish()
            }else{
                startActivity(Intent(this, LoginActivityFF::class.java))
                finish()
            }

        },2000)
    }
}