package com.example.feelfit.GainingExercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.feelfit.DietPlanGain.DietPlanOne
import com.example.feelfit.R

class gaining2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaining2)

        val dietgain2 = findViewById<Button>(R.id.diet12)
        dietgain2.setOnClickListener {
            intent= Intent(this, DietPlanOne::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()

        }

        val arrowgain2 = findViewById<ImageView>(R.id.arrowgaintwo)
        arrowgain2.setOnClickListener {
            intent= Intent(this,Exercise2::class.java)

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }


    }
}