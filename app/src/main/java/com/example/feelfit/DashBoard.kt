package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feelfit.databinding.ActivityDashBoardBinding
import com.google.firebase.auth.FirebaseAuth

class DashBoard : AppCompatActivity() {
    var num=0;

    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn.setOnClickListener {
            intent = Intent(this,BmiCalculator::class.java)
            startActivity(intent)

        }


    }
}