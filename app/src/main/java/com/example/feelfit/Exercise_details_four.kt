package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Exercise_details_four : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details_four)




        val dietfour = findViewById<Button>(R.id.diet4)
        dietfour.setOnClickListener {
            intent= Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()
        }
    }
}