package com.example.feelfit.Credentials
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.feelfit.Dashboard
import com.example.feelfit.GainingExercises.Exercise2
import com.example.feelfit.LosingExercise.ExerciseI
import com.example.feelfit.NormalExercise.NormalActivity
import com.example.feelfit.RoomDB.AppDatabase
import com.example.feelfit.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySplashBinding

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        lateinit var InsDB: AppDatabase

        Handler(Looper.getMainLooper()).postDelayed({
            auth = FirebaseAuth.getInstance()
            var user=auth.currentUser?.email

            if (auth.currentUser != null) {

                InsDB = AppDatabase.getDatabase(applicationContext)
                GlobalScope.launch(Dispatchers.IO) {


                    var enties = user?.let { InsDB.userInfoDao().getAll(it) }
                    Log.e("mello", "Shubh: $enties" + "" )
                    launch(Dispatchers.Main) {
                        var body= enties?.get(0)?.body.toString()
                       Log.e("majil", "=========>:$body ", )


                        if (body== "SEVERE SKINNY")
                        {

                            startActivity(Intent(applicationContext, Exercise2::class.java))
                        }
                        if (body== "MODERATE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))
                        }
                        if (body== "MODERATE SKINNY")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))

                        }
                        if(body== "MILD THINNESS")
                        {
                            startActivity(Intent(applicationContext, Exercise2::class.java))

                        }
                        if(body== "NORMAL")
                        {
                            startActivity(Intent(applicationContext, NormalActivity::class.java))
                        }
                        if(body== "OVERWEIGHT")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                        }
                        if(body== "OBESE I")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                        }
                        if(body== "OBESE II")
                        {
                            startActivity(Intent(applicationContext, ExerciseI::class.java))
                        }
                        else
                        {

                        }
                    }
                }

                startActivity(Intent(applicationContext, Dashboard::class.java))
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish()
            }
            else {

                startActivity(Intent(this, Login::class.java))
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish()
            }

        }, 3000)

    }
}