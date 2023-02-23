package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Exercise_details_six : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details_six)


        val dietsix = findViewById<Button>(R.id.diet6)
        dietsix.setOnClickListener {
            intent= Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()
        }
    }
}