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

class Normal2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal2)


        val Timern2 = findViewById<Button>(R.id.timern2)
        Timern2.setOnClickListener {
            intent = Intent(this,timer::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

            finish()
        }


        val dietnnn = findViewById<Button>(R.id.dietn2)
        dietnnn.setOnClickListener {
            intent = Intent(this, NormalActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
        val arrownormtwo = findViewById<ImageView>(R.id.arrownormal2)
        arrownormtwo.setOnClickListener {
            intent = Intent(this,DietPlanOne::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
    }
}