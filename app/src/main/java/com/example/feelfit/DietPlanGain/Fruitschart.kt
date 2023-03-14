package com.example.feelfit.DietPlanGain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.Description
import com.example.feelfit.DietPlan.DietPlanTwo
import com.example.feelfit.R

class fruitschart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruitschart)

        val desc1 = findViewById<Button>(R.id.desc)
        desc1.setOnClickListener {
            intent=Intent(this, Description::class.java)
            startActivity(intent)
            finish()
        }
        val arrowgainf1 = findViewById<ImageView>(R.id.arrowgainfnonveg)
        arrowgainf1.setOnClickListener {
            intent= Intent(this,DietPlanTwo::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }

    }
}