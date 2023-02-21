package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.databinding.ActivityExerciseDetailsOneBinding

class Exercise_details_one : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseDetailsOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseDetailsOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Arrow = findViewById<ImageView>(R.id.arrow)
        Arrow.setOnClickListener {
            intent = Intent(this,ExerciseI::class.java)
            startActivity(intent)
            finish()
        }
        val Steps = findViewById<Button>(R.id.steps)
        Steps.setOnClickListener {
            intent = Intent(this,showSteps::class.java)
            startActivity(intent)
            finish()
        }
        val diet = findViewById<Button>(R.id.diet)
        diet.setOnClickListener {
            intent = Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()
        }
    }
}