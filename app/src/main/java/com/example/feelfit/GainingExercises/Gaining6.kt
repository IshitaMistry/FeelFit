package com.example.feelfit.GainingExercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.R

class gaining6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaining6)

        val dietgain6 = findViewById<Button>(R.id.diet16)
        dietgain6.setOnClickListener {
            intent= Intent(this, DietPlanOne::class.java)
            startActivity(intent)
            finish()
            
        }

        val arrowgain6 = findViewById<ImageView>(R.id.arrowgainsix)
        arrowgain6.setOnClickListener {
            intent = Intent(this,Exercise2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }
    }
}