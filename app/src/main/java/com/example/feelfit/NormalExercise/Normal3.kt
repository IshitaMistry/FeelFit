package com.example.feelfit.NormalExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.GainingExercises.Exercise2
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
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

            finish()
        }

        val Timern3 = findViewById<Button>(R.id.timern3)
        Timern3.setOnClickListener {
            intent = Intent(this,timer::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

            finish()
        }
        val arrownormthree = findViewById<ImageView>(R.id.arrownormal3)
        arrownormthree.setOnClickListener {
            intent = Intent(this,NormalActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
    }
}