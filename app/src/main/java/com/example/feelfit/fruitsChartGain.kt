package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlanGain.DietPlanOne

class fruitsChartGain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_chart_gain)

        val desc1 = findViewById<Button>(R.id.desc)
        desc1.setOnClickListener {
            intent=Intent(this, Description::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }

        val arrowgainf = findViewById<ImageView>(R.id.arrowgainfruit)
        arrowgainf.setOnClickListener {
            intent= Intent(this,DietPlanOne::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }
    }
}