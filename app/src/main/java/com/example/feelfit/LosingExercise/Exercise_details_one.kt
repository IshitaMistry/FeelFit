package com.example.feelfit.LosingExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlan.DietPlanTwo
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.IntermittentPlan
import com.example.feelfit.R
import com.example.feelfit.databinding.ActivityExerciseDetailsOneBinding
import com.example.feelfit.Sensors.showSteps

class Exercise_details_one : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseDetailsOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseDetailsOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Arrow = findViewById<ImageView>(R.id.arrow)
        Arrow.setOnClickListener {
            onBackPressed()
        }

        val Steps = findViewById<Button>(R.id.steps)
        Steps.setOnClickListener {
            intent = Intent(this, showSteps::class.java)
            startActivity(intent)
            finish()
        }



    }
}