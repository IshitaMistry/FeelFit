package com.example.feelfit.LosingExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.Sensors.ProximitySensor
import com.example.feelfit.R
import com.example.feelfit.databinding.ActivityExerciseDetailsFiveBinding

class Exercise_details_five : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseDetailsFiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseDetailsFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = binding.count
        count.setOnClickListener{

            intent= Intent(applicationContext, ProximitySensor::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()



        }
        val dietfive = findViewById<Button>(R.id.diet5)
        dietfive.setOnClickListener {
            intent=Intent(this, DietPlanOne::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
        }

        val arrow5 = findViewById<ImageView>(R.id.arrow5)
        arrow5.setOnClickListener {
            intent = Intent(this, ExerciseI::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
        }



    }
}