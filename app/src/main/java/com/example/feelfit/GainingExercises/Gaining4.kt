package com.example.feelfit.GainingExercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.R
import java.lang.Exception

class gaining4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaining4)

        val dietgain4 = findViewById<Button>(R.id.diet14)
        dietgain4.setOnClickListener {
            intent= Intent(this, DietPlanOne::class.java)
            startActivity(intent)
            finish()

        }
        val arrorgain4 = findViewById<ImageView>(R.id.arrowgainfour)
        arrorgain4.setOnClickListener {
            intent= Intent(this,Exercise2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }
    }
}