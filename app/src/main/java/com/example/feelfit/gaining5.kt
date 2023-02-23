package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class gaining5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaining5)

        val dietgain5 = findViewById<Button>(R.id.diet15)
        dietgain5.setOnClickListener {
            intent= Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()

        }

    }
}