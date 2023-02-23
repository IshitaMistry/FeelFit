package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class Exercise_details_two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details_two)


        val Timer= findViewById<Button>(R.id.timer)
        Timer.setOnClickListener {
            intent= Intent(this,timer::class.java)
            startActivity(intent)
            finish()
        }


        val diettwo = findViewById<Button>(R.id.diet2)
        diettwo.setOnClickListener {
            intent=Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()
        }

    }
}