package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feelfit.databinding.ActivityExerciseDetailsFiveBinding

class Exercise_details_five : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseDetailsFiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseDetailsFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = binding.count
        count.setOnClickListener{

            intent= Intent(applicationContext,ProximitySensor::class.java)
            startActivity(intent)
            finish()

        }



    }
}