package com.example.feelfit.NormalExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlan.DietPlanTwo
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.GainingExercises.Exercise2
import com.example.feelfit.R
import com.example.feelfit.timer

class Normal1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal1)

        val Timern1= findViewById<Button>(R.id.timern1)
        Timern1.setOnClickListener {
            intent= Intent(this, timer::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }

        val dietnn = findViewById<Button>(R.id.dietn)
        dietnn.setOnClickListener {
            intent = Intent(this, DietPlanOne::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
        val arrownormone = findViewById<ImageView>(R.id.arrownormal1)
        arrownormone.setOnClickListener {
            intent = Intent(this,NormalActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
    }
}