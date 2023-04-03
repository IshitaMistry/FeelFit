package com.example.feelfit.LosingExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlan.DietPlanTwo
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.R

class Exercise_details_three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details_three)




        val arrow3 = findViewById<ImageView>(R.id.arrow3)
        arrow3.setOnClickListener {
            onBackPressed()

        }


    }
}