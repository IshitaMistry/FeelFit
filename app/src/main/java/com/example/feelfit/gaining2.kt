package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class gaining2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaining2)

        val dietgain2 = findViewById<Button>(R.id.diet12)
        dietgain2.setOnClickListener {
            intent= Intent(this,DietPlanOne::class.java)
            startActivity(intent)
            finish()

        }
    }
}