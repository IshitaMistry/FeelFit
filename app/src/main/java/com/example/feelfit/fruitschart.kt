package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class fruitschart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruitschart)


        val desc1 = findViewById<Button>(R.id.desc)
        desc1.setOnClickListener {
            intent=Intent(this,Description::class.java)
            startActivity(intent)
            finish()
        }

    }
}