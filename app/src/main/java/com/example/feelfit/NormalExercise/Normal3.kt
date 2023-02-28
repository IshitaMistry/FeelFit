package com.example.feelfit.NormalExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.feelfit.DietPlan.DietPlanOne
import com.example.feelfit.R
import com.example.feelfit.timer

class Normal3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal3)

        val dietnn3 = findViewById<Button>(R.id.dietn3)
        dietnn3.setOnClickListener {
            intent = Intent(this, DietPlanOne::class.java)
            startActivity(intent)
            finish()
        }

        val Timern3 = findViewById<Button>(R.id.timern3)
        Timern3.setOnClickListener {
            intent = Intent(this,timer::class.java)
            startActivity(intent)
            finish()
        }
    }
}