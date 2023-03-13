package com.example.feelfit.NormalExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.R
import com.example.feelfit.timer

class Normal5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal5)

        val dietnn5 = findViewById<Button>(R.id.dietn5)
        dietnn5.setOnClickListener {
            intent = Intent(this, DietPlanOne::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finish()

        }

        val Timern5 = findViewById<Button>(R.id.timern5)
        Timern5.setOnClickListener {
            intent = Intent(this,timer::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finish()
        }
    }
}