package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.feelfit.databinding.ActivityRnunningBinding

class RnunningAct : AppCompatActivity() {
    private lateinit var binding: ActivityRnunningBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRnunningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkSteps.setOnClickListener(View.OnClickListener {

        intent = Intent(this,StepCounter::class.java)
          startActivity(intent)
        })

    }
}