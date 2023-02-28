package com.example.feelfit.NormalExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.feelfit.DietPlan.DietPlanOne
import com.example.feelfit.R
import com.example.feelfit.timer

class Normal1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal1)

        val Timern1= findViewById<Button>(R.id.timern1)
        Timern1.setOnClickListener {
            intent= Intent(this, timer::class.java)
            startActivity(intent)
            finish()
        }

        val dietnn = findViewById<Button>(R.id.dietn)
        dietnn.setOnClickListener {
            intent = Intent(this, DietPlanOne::class.java)
            startActivity(intent)
            finish()


        }
    }
}