package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Exercise_details_three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details_three)


        val dietthree =  findViewById<Button>(R.id.diet3)
        dietthree.setOnClickListener {
            intent=Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()
        }

        val arrow3 = findViewById<ImageView>(R.id.arrow3)
        arrow3.setOnClickListener {
            intent = Intent(this, ExerciseI::class.java)
            startActivity(intent)
            finish()
        }


    }
}